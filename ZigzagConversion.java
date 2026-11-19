public class ZigzagConversion {

    public String convert(String s, int numRows) {
        // Edge case: if only 1 row or string is shorter than rows, return as is
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction at top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to next row
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        // Example 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", numRows = " + numRows1);
        System.out.println("Output: \"" + solution.convert(s1, numRows1) + "\"");
        System.out.println("Expected: \"PAHNAPLSIIGYIR\"");
        System.out.println();

        // Example 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Example 2:");
        System.out.println("Input: s = \"" + s2 + "\", numRows = " + numRows2);
        System.out.println("Output: \"" + solution.convert(s2, numRows2) + "\"");
        System.out.println("Expected: \"PINALSIGYAHRPI\"");
        System.out.println();

        // Example 3
        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Example 3:");
        System.out.println("Input: s = \"" + s3 + "\", numRows = " + numRows3);
        System.out.println("Output: \"" + solution.convert(s3, numRows3) + "\"");
        System.out.println("Expected: \"A\"");
    }
}