class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if(val == target){
                return mid;
            }
            else if(val < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}