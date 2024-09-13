class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] prefixXor = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }
        int[] out = new int[m];
        for(int i= 0; i < m; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            out[i] = prefixXor[end + 1] ^ prefixXor[start];
        }
        return out;
    }
}