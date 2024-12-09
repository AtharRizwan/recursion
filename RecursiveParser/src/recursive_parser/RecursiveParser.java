package recursive_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveParser {

    /**
     * Evaluates a mathematical expression with +, -, *, / operators.
     * No parentheses are supported.
     * 
     * @param expression the input mathematical expression
     * @return the evaluated result as a double
     */
    public static double evaluateExpression(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Invalid expression!");
        }
        if (expression.contains("(") || expression.contains(")")) {
            throw new IllegalArgumentException("Parentheses not supported!");
        }
        return evaluateAdditionSubtraction(expression);
    }

    /**
     * Evaluates addition and subtraction operators.
     * 
     * @param expr the input expression
     * @return the calculated result
     */
    private static double evaluateAdditionSubtraction(String expr) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                double left = evaluateAdditionSubtraction(expr.substring(0, i));
                double right = evaluateAdditionSubtraction(expr.substring(i + 1, expr.length()));
                return calculate(left, right, expr.charAt(i));
            }
        }
        return evaluateMultiplicationDivision(expr);
    }

    /**
     * Evaluates multiplication and division operators.
     * 
     * @param expr the input expression
     * @return the calculated result
     */
    private static double evaluateMultiplicationDivision(String expr) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            if (expr.charAt(i) == '*' || expr.charAt(i) == '/') {
                double left = evaluateMultiplicationDivision(expr.substring(0, i));
                double right = evaluateMultiplicationDivision(expr.substring(i + 1, expr.length()));
                return calculate(left, right, expr.charAt(i));
            }
        }
        return Double.parseDouble(expr);
    }

    /**
     * Performs a basic arithmetic operation.
     * 
     * @param left     the left operand
     * @param right    the right operand
     * @param operator the arithmetic operator
     * @return the calculated result
     * @throws IllegalArgumentException if the operator is invalid
     * @throws ArithmeticException      if division by zero is attempted
     */
    private static double calculate(double left, double right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                if (right == 0)
                    throw new ArithmeticException("Division by zero!");
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Take input expression
        System.out.print("Enter a mathematical expression: ");
        String expression = reader.readLine().replaceAll("\\s+", "");

        try {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
