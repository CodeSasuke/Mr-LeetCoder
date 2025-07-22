class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int[] hash = new int[26];
        int max = 0;
        int maxf = 0;
        while(r < n){
            char r_ = s.charAt(r);
            char l_ = s.charAt(l);
            hash[r_-'A']++;
            maxf = Math.max(maxf,hash[r_-'A']);
            int len = r - l + 1;
            if(len - maxf > k){
                hash[l_-'A']--;
                l++;
            }
            if(len - maxf <= k){
                max = Math.max(max,len);
            }
            r++;
        }
        return max;
    }
}