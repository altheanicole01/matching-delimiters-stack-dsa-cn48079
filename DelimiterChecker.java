/* Description: This program uses a stack to check whether
a sequence of (), [], and {} delimiters is properly matched and
displays whether it is Valid or Invalid.
Programmed by: Althea Nicole C. Peñaranda - BSIT - CN48079 - DATA STRUCTURES AND ALGORITHMS
Last Modified: October 23, 2026
Version: 1.0
[Acknowledgements: https://www.geeksforgeeks.org/dsa/check-for-balanced-parentheses-in-an-expression/
Generative AI used: Perplexity, Prompt: Format, check, and fix the errors of the following code.]
*/

import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of delimiters: ");
        String input = scanner.nextLine();

        if (isValid(input)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
            System.out.println("Reason: " + getErrorMessage(input));
        }

        scanner.close();
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if ((current == ')' && top == '(') ||
                    (current == ']' && top == '[') ||
                    (current == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static String getErrorMessage(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    return "closing delimiter has no matching opening delimiter";
                }

                char top = stack.peek();

                if ((current == ')' && top == '(') ||
                    (current == ']' && top == '[') ||
                    (current == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return "mismatched delimiters";
                }
            }
        }

        if (!stack.isEmpty()) {
            return "unmatched opening delimiter remains";
        }

        return "valid sequence";
    }
}
