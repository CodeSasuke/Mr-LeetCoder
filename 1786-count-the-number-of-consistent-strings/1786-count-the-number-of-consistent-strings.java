class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // char[] allowedChar = new String[allowed.length()];
        // for(int i = 0; i < allowedChar.length;i++){
        //     allowedChar[i]= allowed.getcharAt(i);
        // }
        int count = 0;
        for(int i = 0; i < words.length; i++){
            // int flag = 1;
            // for(char ch : words[i]){
                for(int j = 0; j < words[i].length();j++){
                if(!allowed.contains(String.valueOf(words[i].charAt(j)))){
                    // flag = 0;
                    count--;
                    break;
                }
                }
                // if(flag == 1)
                count++;
                // }
        }
        return count;
    }
}