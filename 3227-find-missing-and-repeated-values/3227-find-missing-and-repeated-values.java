class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int original = 0;
        int original_square = 0;
        for(int i = 1; i <= n * n; i++){
            original+=i;
            original_square += i * i;
        }
        int given = 0;
        int given_square = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                given+=grid[i][j];
                given_square += grid[i][j] * grid[i][j];
            }
        }
        int A = original - given;
        int B = original_square - given_square;
        int K = B / A;
        return new int[]{(K - A) / 2, (K + A) / 2};



    }
}