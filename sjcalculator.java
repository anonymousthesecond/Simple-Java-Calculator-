import java.util.Stack;
import java.util.Scanner;

public class Number {
    private double real;
    private double imaginary;

    public Number(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Number(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getter methods for real and imaginary parts
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Methods for basic arithmetic operations (assuming real or complex numbers)
    public Number add(Number other) {
        return new Number(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Number subtract(Number other) {
        return new Number(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Number multiply(Number other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Number(newReal, newImaginary);
    }

    public Number divide(Number other) throws Exception {
        if (other.getReal() == 0 && other.getImaginary() == 0) {
            throw new Exception("Division by zero");
        }
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Number(newReal, newImaginary);
    }

    // Check if the number is complex
    public boolean isComplex() {
        return imaginary != 0;
    }

    // Override toString for a better representation
    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.valueOf(real);
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}

public class ExpressionEvaluator {

    public Number evaluate(String expression) throws Exception {
        Stack<String> operatorStack = new Stack<>();
        Stack<Number> operandStack = new Stack<>();

        // Split the expression based on spaces (assuming no spaces within numbers)
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                operandStack.push(new Number(Double.parseDouble(token)));
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(token, operatorStack.peek())) {
                    Number operand2 = operandStack.pop();
                    Number operand1 = operandStack.pop();
                    String operator = operatorStack.pop();
                    Number result = evaluateOperation(operand1, operand2, operator);
                    operandStack.push(result);
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    Number operand2 = operandStack.pop();
                    Number operand1 = operandStack.pop();
                    String operator = operatorStack.pop();
                    Number result = evaluateOperation(operand1, operand2, operator);
                    operandStack.push(result);
                }
                operatorStack.pop(); // Remove the "("
            } else {
                throw new Exception("Invalid token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            Number operand2 = operandStack.pop();
            Number operand1 = operandStack.pop();
            String operator = operatorStack.pop();
            Number result = evaluateOperation(operand1, operand2, operator);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException
