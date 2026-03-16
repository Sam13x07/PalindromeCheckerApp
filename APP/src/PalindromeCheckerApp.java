import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String text) {
        if (strategy == null) {
            System.out.println("Error: Strategy not initialized.");
            return false;
        }
        return strategy.isPalindrome(text);
    }

    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter text to check: ");
        String userInput = scanner.nextLine();

        System.out.println("\nSelect Algorithm Strategy:");
        System.out.println("1. Stack Strategy (LIFO approach)");
        System.out.println("2. Deque Strategy (Double-ended approach)");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            app.setStrategy(new StackStrategy());
            System.out.println("Applied: StackStrategy");
        } else if (choice == 2) {
            app.setStrategy(new DequeStrategy());
            System.out.println("Applied: DequeStrategy");
        } else {
            System.out.println("Invalid choice. Defaulting to Stack.");
            app.setStrategy(new StackStrategy());
        }

        boolean result = app.executeCheck(userInput);

        System.out.println("------------------------------------");
        System.out.println("Input: " + userInput);
        System.out.println("Is Palindrome: " + result);
        System.out.println("------------------------------------");

        scanner.close();
    }
}