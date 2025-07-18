class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int left = 0;
        int right = 1;
        int count = 0;
        while(right<=n && left < n){
            String sub = s.substring(left, right);
            if(helper(sub)){
                int len = right - left;
                count = Math.max(count,len);
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
    public static boolean helper(String str) {
        Set<Character> seen = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (seen.contains(ch)) {
                return false;
            }
            seen.add(ch);
        }
        return true;
    }
}