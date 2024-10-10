class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int rev = 0;
        int dum = x;
        while(dum > 0){
            int ld = dum % 10;
            // if (rev > (Integer.MAX_VALUE - ld) / 10) {
            //     return false; // Overflow will occur
            // }
            rev = (rev * 10) + ld;
            dum/=10;
        }
        return rev == x;
    }
}