## Advanced Java Calculator: User Guide

This document provides a detailed guide on using the advanced Java calculator we built together.

**1. Introduction**

This calculator is a command-line application written in Java. It can handle basic arithmetic operations (+, -, *, /) on both real and complex numbers, along with parentheses for evaluating expressions with specific order of operations.

**2. System Requirements**

- Java Runtime Environment (JRE) version 8 or later. You can download and install it from the official Java website: [https://www.java.com/download/ie_manual.jsp](https://www.java.com/download/ie_manual.jsp)

**3. Usage**

**3.1 Compiling the Code**

1. Save the code in a Java file named `Calculator.java`.
2. Open a terminal or command prompt and navigate to the directory where you saved the file.
3. Use the `javac` command to compile the code:

   ```bash
   javac Calculator.java
   ```

   This will create a class file named `Calculator.class`.

**3.2 Running the Calculator**

1. In the same terminal, use the `java` command to run the program:

   ```bash
   java Calculator
   ```

   This will start the calculator and display a message like "Enter expression (or 'quit' to exit):"

**3.3 Entering Expressions**

- You can enter mathematical expressions in the following format:

   ```
   <operand1> <operator> <operand2>

   ( <expression1> ) <operator> <operand3>

   <complex number 1> <operator> <complex number 2>
   ```

   - `<operand1>` and `<operand2>` can be real numbers (e.g., 2, 3.14) or complex numbers (e.g., 1+2i, 4-5i).
   - `<operator>` can be one of the following arithmetic operators:
      - `+` (addition)
      - `-` (subtraction)
      - `*` (multiplication)
      - `/` (division)
   - Parentheses can be used to group expressions and define the order of operations.
   - Complex numbers are represented as `<real part> + <imaginary part>i`. The imaginary unit `i` is case-insensitive.

- **Examples:**

   ```
   2 + 3            # Evaluates to 5
   (5 - 2) * 4      # Evaluates to 12
   3 + 4i           # Complex number
   (2 + 3i) * (1 - 2i) # Complex number multiplication
   ```

**3.4 Exiting the Calculator**

- To exit the calculator, type `quit` (case-insensitive) and press Enter. The program will terminate.

**4. Limitations**

- This is a basic implementation and doesn't include features like trigonometric functions, logarithms, or a graphical user interface.
- Error handling can be improved to provide more specific messages for invalid expressions.

**5. Further Enhancements**

- You can modify the code to add more functionalities or integrate libraries for advanced mathematical operations.
- You can build a graphical user interface (GUI) using Swing or JavaFX to create a more user-friendly experience.

**6. Additional Notes**

- The calculator assumes no spaces within numbers. If you want to include spaces in numbers (e.g., "ten"), you'll need to modify the parsing logic to handle them appropriately.
- The current implementation throws an exception for division by zero. You can improve error handling to provide a more informative message in such cases.

This guide should equip you to use the advanced Java calculator effectively. Feel free to explore the code further and customize it based on your specific needs.1
