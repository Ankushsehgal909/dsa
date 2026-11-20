public class ReverseInteger {

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before multiplying by 10
            // INT_MAX = 2147483647, INT_MIN = -2147483648
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    // Main method for testing
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        // Example 1
        int x1 = 123;
        System.out.println("Example 1:");
        System.out.println("Input: x = " + x1);
        System.out.println("Output: " + solution.reverse(x1));
        System.out.println("Expected: 321");
        System.out.println();

        // Example 2
        int x2 = -123;
        System.out.println("Example 2:");
        System.out.println("Input: x = " + x2);
        System.out.println("Output: " + solution.reverse(x2));
        System.out.println("Expected: -321");
        System.out.println();

        // Example 3
        int x3 = 120;
        System.out.println("Example 3:");
        System.out.println("Input: x = " + x3);
        System.out.println("Output: " + solution.reverse(x3));
        System.out.println("Expected: 21");
        System.out.println();

        // Edge cases
        System.out.println("Edge case: 1534236469 (overflow)");
        System.out.println("Output: " + solution.reverse(1534236469));
        System.out.println("Expected: 0");

        System.out.println("\nEdge case: -2147483648 (INT_MIN)");
        System.out.println("Output: " + solution.reverse(-2147483648));
        System.out.println("Expected: 0");
    }
}