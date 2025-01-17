class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            char key = s.charAt(i);
            int freq = 0;
            if(map1.containsKey(key)){
                freq = map1.get(key);
            }
            freq++;
            map1.put(key, freq);
        }
        for(int i = 0; i < m; i++){
            char key = t.charAt(i);
            int freq = 0;
            if(map2.containsKey(key)){
                freq = map2.get(key);
            }
            freq++;
            map2.put(key, freq);
        }
        for (Map.Entry<Character, Integer> it : map1.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
            char key = it.getKey();
            int freq = it.getValue();
            if(!map2.containsKey(key) || map2.get(key)!=freq){
                return false;
            }
        }
        return true;
    }
}