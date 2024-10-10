class Solution {
    public String addBinary(String a, String b) {
        // if(Integer.parseInt(a) == 0){
        //     return b;
        // }if(Integer.parseInt(b) == 0){
        //     return a;
        // }
        StringBuilder result = new StringBuilder();
        int al = a.length() - 1; // The lsb of a
        int bl = b.length() - 1; // The lsb of b
        int carry = 0;
        while(al >= 0 || bl >= 0 || carry == 1){
            int res = carry;
            if(al >= 0){
                res += a.charAt(al) - '0';
                al--;
            }
            if(bl >= 0){
                res += b.charAt(bl) - '0';
                bl--;
            }
            result.append(res % 2);
            carry = res / 2;
        }
        return result.reverse().toString();
    }
}