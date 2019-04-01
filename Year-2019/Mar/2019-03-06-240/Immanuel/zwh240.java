class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1||matrix[0].length < 1)
            return false;
        int M = matrix.length;
        int N = matrix[0].length;
        if(target < matrix[0][0]|| target > matrix[M - 1][N - 1])
            return false;
        
        int bi = M - 1, bj = N - 1;
        for(; bi >= 0; bi--){
            if(target > matrix[bi][N - 1])
                break;
        }
        
        for(; bj >= 0; bj--){
            if(target > matrix[M - 1][bj])
                break;
        }
        for(int i = bi + 1; i < M; i++){
            for(int j = bj + 1; j < N; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}