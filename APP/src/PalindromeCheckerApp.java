import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker (Ignore Case & Spaces) ===\n");

        while (true) {
            System.out.print("Enter a string (or 'quit' to exit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            boolean isPalindrome = isPalindromeIgnoreCaseAndSpaces(input);

            System.out.println("\nInput    : \"" + input + "\"");
            System.out.println("Result   : " + (isPalindrome ? "YES, it is a palindrome" : "NO, not a palindrome"));
            System.out.println("----------------------------------------\n");
        }

        scanner.close();
    }

    public static boolean isPalindromeIgnoreCaseAndSpaces(String str) {
        if (str == null) {
            return false;
        }

        String cleaned = str
                .toLowerCase()
                .replaceAll("[^a-z]", "");

        return isPalindrome(cleaned);
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}