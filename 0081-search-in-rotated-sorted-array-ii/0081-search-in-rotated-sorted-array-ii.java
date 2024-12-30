class Solution {
  public boolean search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int val = nums[mid];
      if (val == target) {
        return true;
      }
      if (val == nums[lo] && val == nums[hi]) {
        lo++;
        hi--;
        continue;
      }
      if (nums[lo] <= val) // This means sorted left half 
      {

        if (nums[lo] <= target && val > target) {
          // Target is in the left half.
          hi = mid - 1;
        } else {
          //The target is in unsorted right half
          lo = mid + 1;
        }
      } else // This means the Right half is sorted
      {
        if (target <= nums[hi] && target > val) {
          // Target is in sorted right half
          lo = mid + 1;
        } else {
          // Target is in the unsorted left half
          hi = mid - 1;
        }
      }
    }
    return false;
  }
}