import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker using Queue + Stack (UC6) ===");
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleaned.isEmpty()) {
            System.out.println("No valid characters entered.");
            return;
        }

        boolean isPalindrome = isPalindromeUsingQueueAndStack(cleaned);

        System.out.println("\nOriginal input     : " + input);
        System.out.println("Cleaned version    : " + cleaned);
        System.out.println("Is palindrome?     : " + isPalindrome);

        if (cleaned.length() <= 40) {
            showComparisonProcess(cleaned);
        } else {
            System.out.println("(String too long to show detailed step-by-step comparison)");
        }

        scanner.close();
    }

    public static boolean isPalindromeUsingQueueAndStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty() && !stack.isEmpty()) {
            char front = queue.remove();
            char top   = stack.pop();

            if (front != top) {
                return false;
            }
        }

        return true;
    }

    public static void showComparisonProcess(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        System.out.println("\nStep-by-step comparison:");
        System.out.println("Character | Queue (FIFO) | Stack (LIFO)");
        System.out.println("----------|--------------|-------------");

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        int step = 1;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            char qChar = queue.remove();
            char sChar = stack.pop();

            String match = (qChar == sChar) ? "✓ match" : "✗ mismatch";

            System.out.printf("%-9d | %-12c | %-c %s%n",
                    step, qChar, sChar, match);

            if (qChar != sChar) {
                System.out.println("→ Not a palindrome");
                return;
            }
            step++;
        }

        System.out.println("→ All characters matched → It is a palindrome!");
    }
}