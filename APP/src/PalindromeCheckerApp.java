import java.util.*;

interface PalindromeStrategy {
    String getName();
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    public String getName() { return "Stack-based Strategy"; }
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    public String getName() { return "Deque-based Strategy"; }
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    public String getName() { return "Two-Pointer Strategy"; }
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Performance Comparison ===");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("\nRunning Benchmarks...\n");
        System.out.printf("%-25s | %-12s | %-15s\n", "Strategy", "Result", "Time (nanosec)");
        System.out.println("------------------------------------------------------------");

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();


            boolean result = strategy.isPalindrome(input);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System. Bihprintf("%-25s | %-12s | %-15d\n",
                    strategy.getName(),
                    (result ? "Palindrome" : "Not Palindrome"),
                    duration);
        }

        System.out.println("------------------------------------------------------------");
        scanner.close();
    }
}