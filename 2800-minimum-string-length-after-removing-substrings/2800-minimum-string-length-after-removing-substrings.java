class Solution {
    public int minLength(String s) {
        String remove1 = "AB";
        String remove2 = "CD";
        int count = 0;
        while(s.contains(remove1) || s.contains(remove2)){
            s = s.replace(remove1,"");
            s = s.replace(remove2,"");
        }
        return s.length();
    }
}