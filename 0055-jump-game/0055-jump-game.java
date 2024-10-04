class Solution {
    public boolean canJump(int[] nums) {
        int step = 0;
        for(int n : nums){
            if (step  < 0)
            return false;
            else if(n > step)
            step = n;
            step--;
        }
        return true;
    }
}