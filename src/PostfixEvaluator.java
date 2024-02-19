import java.util.ArrayDeque;
import java.util.Deque;


public class PostfixEvaluator {
    public static double evaluatePostfix(String expression) {
        Deque<Double> stack = new ArrayDeque<>();

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                double result = performOperation(token, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "5 2 + 8 3 - * 4 *";
        double result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }
}
