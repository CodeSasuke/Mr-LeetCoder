class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<>();
        HashMap <Integer,Integer> hm=new HashMap<>();
        int[] ans=new int[nums1.length];
        for(int num:nums2){
            while(!s.isEmpty() && num>s.peek()){
                hm.put(s.pop(),num);
            }
            s.push(num);
        }
        for(int i=0;i<nums1.length;i++){
              ans[i]=hm.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}