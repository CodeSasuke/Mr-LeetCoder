class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, target);
        if(lb == n || nums[lb] != target)
        {
            return new int[] {-1, -1};
        }
        int ub = upperBound(nums, target);
        return new int [] {lb, ub - 1};
    }
    private int lowerBound(int[] nums, int target){
        int n = nums.length;
        int lo = 0; 
        int hi = n - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if(val >= target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    private int upperBound(int[] nums, int target){
        int n = nums.length;
        int lo = 0; 
        int hi = n - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if(val > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}