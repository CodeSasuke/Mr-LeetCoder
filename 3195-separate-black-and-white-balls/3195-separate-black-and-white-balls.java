class Solution {
    public long minimumSteps(String s) {
        // Check if the length of the string is less than 64
        if (s.length() < 64) {
            long num = Long.parseUnsignedLong(s, 2); // Convert binary string to unsigned long
            long mask = (1L << Long.bitCount(num)) - 1; // Create a mask of '1's for the count of '1's

            // If num equals the mask, no swaps are needed
            if (num == mask) return 0;
        }

        int cur = 0; 
        long res = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // Add the number of swaps required
                res += (i - cur);
                // Increment the current count of '1's encountered
                cur++;
            }
        }

        return res; // Return the total number of swaps needed
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "100110";  // Example input
        System.out.println("Minimum steps: " + sol.minimumSteps(input));  // Output: 3
    }
}
