class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int rev = 0;
        int dum = x;
        while(dum > 0){
            int ld = dum % 10;
            rev = (rev * 10) + ld;
            dum/=10;
        }
        return (rev == x) ? true : false;
    }
}