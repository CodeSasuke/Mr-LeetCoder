class Solution {
  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;
    int mid = 0;
    if (n == 1) {
      return nums[0];
    }
    if (nums[0] != nums[1]) {
      return nums[0];
    }
    while (lo <= hi) {
      mid = lo + (hi -lo) / 2;
      int val = nums[mid];
      if (val == nums[mid - 1]) {
        if ((mid - 1) % 2 == 0) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      } else {
        if ((mid) % 2 == 0) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }
    System.out.println(lo);
    System.out.println(hi);
    System.out.println(mid);
    return nums[hi];
  }
}