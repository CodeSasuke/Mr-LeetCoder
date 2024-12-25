class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    markRows(i, matrix);
                    markCols(j, matrix);
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 2001){
                    matrix[i][j] = 0;
                }
            }
        }
       

    }
    private void markRows(int i, int[][] matrix){
        int cols = matrix[i].length;
        for(int j = 0; j < cols; j++){
            if(matrix[i][j] != 0){
                matrix[i][j] =  2001;
            }
        }
    }
    private void markCols(int j, int[][] matrix){
        int rows = matrix.length;
        for(int i = 0; i < rows; i++){
            if(matrix[i][j] != 0){
                matrix[i][j] =  2001;
            }
        }
    }
}