class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0,list,temp, nums);
        return list;
    }
    private void helper(int idx,List<List<Integer>> list,List<Integer> temp,int[] nums){
        if(idx == nums.length){
            if(!list.contains(temp)){
                list.add(new ArrayList<>(temp));
            }
            
            return;
        }
        temp.add(nums[idx]);
        helper(idx+1,list,temp,nums);
        temp.remove(temp.size() - 1);
        helper(idx + 1, list, temp, nums);
        return;
    }
}