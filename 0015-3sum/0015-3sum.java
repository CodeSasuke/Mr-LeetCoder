class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int pt1 = 0; pt1 < n - 2; pt1++){
            if (pt1 > 0 && nums[pt1] == nums[pt1 - 1]){
                continue;
            }
            int pt2 = pt1 + 1;
            int pt3 = n - 1;
            while(pt2 < pt3){
                int val = nums[pt2] + nums[pt1] + nums[pt3];
                if(val == 0){
                    list.add(Arrays.asList(nums[pt1], nums[pt2], nums[pt3]));
                    while (pt2 < pt3 && nums[pt2] == nums[pt2 + 1]) pt2++;
                    while (pt2 < pt3 && nums[pt3] == nums[pt3 - 1]) pt3--;

                    pt2++;
                    pt3--;
                }
                else if(val < 0)
                {
                    pt2++;
                }
                else{
                    pt3--;
                }
            }
        }
        return list;
    }
}