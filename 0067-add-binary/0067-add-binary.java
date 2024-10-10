class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int al = a.length() - 1; // Pointer for string a
        int bl = b.length() - 1; // Pointer for string b
        int carry = 0;

        // Loop until both strings are processed or there's still a carry
        while (al >= 0 || bl >= 0 || carry != 0) {
            int sum = carry; // Start with carry

            // Add the current bit of 'a', if within bounds
            if (al >= 0) {
                sum += a.charAt(al) - '0'; // Convert char '0' or '1' to int
                al--; // Move to the next bit (left)
            }

            // Add the current bit of 'b', if within bounds
            if (bl >= 0) {
                sum += b.charAt(bl) - '0'; // Convert char '0' or '1' to int
                bl--; // Move to the next bit (left)
            }

            // Append the current bit (sum % 2) to the result
            result.append(sum % 2);

            // Update the carry (sum / 2)
            carry = sum / 2;
        }

        // Since we've been appending bits in reverse order, reverse the result at the end
        return result.reverse().toString();
    }
}
