class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize result array with -1 (default value when no greater element exists)
        Arrays.fill(ans, -1);
        
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % n];
            }
            // Push indices of the first pass only
            if (i < n) stack.push(i);
        }
        return ans;
    }
}
