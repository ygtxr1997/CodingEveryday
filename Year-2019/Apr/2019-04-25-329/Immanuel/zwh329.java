//memorized depth-first search
public class Solution {
    int rowSize;
    int colSize;
    int[][] matrix;
    int[][] maxPath;
    private void dfs(int rowPos, int colPos){
        int max = 1;
        int tmp = matrix[rowPos][colPos];

        if(rowPos - 1 >= 0&& matrix[rowPos - 1][colPos] < tmp){
            if(maxPath[rowPos - 1][colPos] == 0)
                dfs(rowPos - 1, colPos);
            max = Math.max(max, 1 + maxPath[rowPos - 1][colPos]);
        }
        if(rowPos + 1 < rowSize&& matrix[rowPos + 1][colPos] < tmp){
            if(maxPath[rowPos + 1][colPos] == 0)
                dfs(rowPos + 1, colPos);
            max = Math.max(max, 1 + maxPath[rowPos + 1][colPos]);
        }
        if(colPos - 1 >= 0&& matrix[rowPos][colPos - 1] < tmp){
            if(maxPath[rowPos][colPos - 1] == 0)
                dfs(rowPos, colPos - 1);
            max = Math.max(max, 1 + maxPath[rowPos][colPos - 1]);
        }
        if(colPos + 1 < colSize&& matrix[rowPos][colPos + 1] < tmp){
            if(maxPath[rowPos][colPos + 1] == 0)
                dfs(rowPos, colPos + 1);
            max = Math.max(max, 1 + maxPath[rowPos][colPos + 1]);
        }

        maxPath[rowPos][colPos] = max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        rowSize = matrix.length;
        if(rowSize < 1)
            return 0;
        colSize = matrix[0].length;
        maxPath = new int[rowSize][colSize];

        int outPut = 0;
        for(int i = 0; i < rowSize; i++){
            for (int j = 0; j < colSize; j++){
                if(maxPath[i][j] == 0)
                    dfs(i, j);
                outPut = Math.max(outPut, maxPath[i][j]);
            }
        }

        return outPut;
    }
    
    
// //时间复杂度O(rowSize^2 * colSize^2)
//     int rowSize;
//     int colSize;
//     int[][] matrix;
    
//     private int getIncreasingPath(int rowPos, int colPos){
//         int outPut = 1;
//         int tmp = matrix[rowPos][colPos];
        
//         if(rowPos - 1 >= 0&& matrix[rowPos - 1][colPos] > tmp){
//             outPut = Math.max(outPut, 1 + getIncreasingPath(rowPos - 1, colPos));
//         }
//         if(rowPos + 1 < rowSize&& matrix[rowPos + 1][colPos] > tmp){
//             outPut = Math.max(outPut, 1 + getIncreasingPath(rowPos + 1, colPos));
//         }
//         if(colPos - 1 >= 0&& matrix[rowPos][colPos - 1] > tmp){
//             outPut = Math.max(outPut, 1 + getIncreasingPath(rowPos, colPos - 1));
//         }
//         if(colPos + 1 < colSize&& matrix[rowPos][colPos + 1] > tmp){
//             outPut = Math.max(outPut, 1 + getIncreasingPath(rowPos, colPos + 1));
//         }
        
//         return outPut;
//     }
    
//     public int longestIncreasingPath(int[][] matrix) {
//         this.matrix = matrix;
//         rowSize = matrix.length;
//         if(rowSize < 1)
//             return 0;
//         colSize = matrix[0].length;
        
//         int outPut = 0;
//         for(int i = 0; i < rowSize; i++){
//             for (int j = 0; j < colSize; j++){
//                 outPut = Math.max(outPut, getIncreasingPath(i, j));
//             }
//         }
        
//         return outPut;
//     }
}