/* Description: This program uses a stack to check whether
a sequence of (), [], and {} delimiters is properly matched and
displays whether it is Valid or Invalid. It also displays the
stack operation performed while processing each character.

Programmed by: Althea Nicole C. Peñaranda - BSIT - CN48079 - DATA STRUCTURES AND ALGORITHMS
Last Modified: October 23, 2026
Version: 2.0
[Acknowledgements: [https://www.geeksforgeeks.org/dsa/check-for-balanced-parentheses-in-an-expression/](https://www.geeksforgeeks.org/dsa/check-for-balanced-parentheses-in-an-expression/)
Generative AI used: Perplexity, Prompt: Modify this program so that it displays the stack operation performed while processing the input.]
*/

import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of delimiters: ");
        String input = scanner.nextLine();

        System.out.println("\nStack Trace:");

        boolean valid = isValid(input);

        System.out.println();

        if (valid) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        scanner.close();
    }

    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            System.out.println("Read: " + current);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);

                System.out.println("Operation: PUSH " + current);
                System.out.println("Stack: " + getStackContents(stack));
            } else if (current == ')' || current == ']' || current == '}') {

                if (stack.isEmpty()) {
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: closing delimiter has no matching opening delimiter");
                    return false;
                }

                char top = stack.peek();

                System.out.println("Operation: PEEK -> " + top);

                if ((current == ')' && top == '(') ||
                    (current == ']' && top == '[') ||
                    (current == '}' && top == '{')) {

                    stack.pop();

                    System.out.println("Operation: POP " + top);
                    System.out.println("Stack: " + getStackContents(stack));
                } else {
                    System.out.println("Operation: INVALID");
                    System.out.println("Reason: mismatched delimiters");
                    return false;
                }
            } else {
                System.out.println("Operation: SKIPPED");
                System.out.println("Stack: " + getStackContents(stack));
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Operation: INVALID");
            System.out.println("Reason: unmatched opening delimiter remains");
            return false;
        }

        return true;
    }

    public static String getStackContents(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return "(empty)";
        }

        String result = "";

        for (int i = 0; i < stack.size(); i++) {
            result = result + stack.get(i) + " ";
        }

        return result.trim();
    }
}
