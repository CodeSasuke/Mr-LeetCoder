class Solution {
    public int minAddToMakeValid(String s) {
        int openParen = 0;
        int closeParen = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openParen++;
            }else if(ch == ')' && openParen > 0){
                openParen--;
            }else{
                closeParen++;
                
            }
        }
        return openParen+closeParen;
    }
}