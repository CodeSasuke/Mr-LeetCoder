class Solution {
    public int[] singleNumber(int[] nums) {
        */
        int n = nums.length;
        int first = 0;
        int second = 0;
        Arrays.sort(nums);
        for(int i = 1; i < n; i=i+2){
            if(nums[i] != nums[i-1]){
                first = nums[i];
            }
        }
        int xor = 0;
        for(int x : nums){
            xor^=x;
        }
        second = xor ^ first;
        return new int[]{first, second};
    }
}