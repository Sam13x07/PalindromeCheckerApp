import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker - UC3: Using String Reverse ===");
        System.out.println("Enter a string to check if it is a palindrome:");
        String original = scanner.nextLine();

        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleaned.isEmpty()) {
            System.out.println("No valid characters entered.");
            scanner.close();
            return;
        }

        String reversed = reverseString(cleaned);

        boolean isPalindrome = cleaned.equals(reversed);

        System.out.println("\nOriginal input (cleaned): " + cleaned);
        System.out.println("Reversed string         : " + reversed);
        System.out.println("Is palindrome?          : " + isPalindrome);

        if (isPalindrome) {
            System.out.println("→ Yes, it reads the same forwards and backwards!");
        } else {
            System.out.println("→ No, it is not a palindrome.");
        }

        scanner.close();
    }

    public static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);

        }

        return reversed;
    }
}