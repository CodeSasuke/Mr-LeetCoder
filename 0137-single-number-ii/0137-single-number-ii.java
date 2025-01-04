class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}