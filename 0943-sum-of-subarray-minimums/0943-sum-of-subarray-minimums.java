import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        int mod = (int) (1e9 + 7); // Use 1e9 + 7 instead of Math.pow for efficiency
        int[] pse = new int[n]; // Store indexes of Previous Smaller Element
        int[] nse = new int[n]; // Store indexes of Next Smaller Element

        Stack<Integer> stack = new Stack<>();

        // Compute Previous Smaller Element (Indexes)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // Strictly smaller for correct PSE
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Compute Next Smaller Element (Indexes)
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // Must be <= for correct NSE
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Compute sum of subarray minimums
        for (int i = 0; i < n; i++) {
            int right = (nse[i] - i);
            int left = (i - pse[i]);
            long mul = ((long)right * left) % mod;
            mul = (arr[i] * mul) % mod;
            ans = (ans + mul) % mod;

        }

        return (int)ans; // No need to take % mod again
    }
}

/*
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int mod = (int) (Math.pow(10,9) + 7);
        for(int i = 0; i < n; i++){
            int min = arr[i];
            for(int j = i; j < n; j++){
                min = Math.min(min,arr[j]);
                ans = (ans + min) % mod;
            }
        }
        return ans % mod;
    }
}
*/