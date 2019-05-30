public class Solution {
    //以矩阵中的每个点为square的左上角，向右下角expand
    int rowSize;
    int colSize;
    char[][] matrix;

    private int expand(int rowBegin, int colBegin, int rowEnd, int colEnd){
        if(rowEnd >= rowSize|| colEnd >= colSize|| matrix[rowEnd][colEnd] == '0')
            return 0;

        for(int i = rowBegin; i < rowEnd; i++){
            if(matrix[i][colEnd] == '0')
                return 0;
        }
        for(int i = colBegin; i < colEnd; i++){
            if(matrix[rowEnd][i] == '0')
                return 0;
        }

        return rowEnd - rowBegin + colEnd - colBegin + 1 + expand(rowBegin, colBegin, rowEnd + 1, colEnd + 1);
    }


    public int maximalSquare(char[][] matrix) {
        rowSize = matrix.length;
        if(rowSize < 1)
            return 0;
        colSize = matrix[0].length;
        this.matrix = matrix;

        int outPut = 0;
        for(int i = 0; i < rowSize; i++){
            for (int j = 0; j < colSize; j++){
                //if(matrix[i][j] == '1')
                outPut = Math.max(outPut, expand(i, j, i, j));
            }
        }

        return outPut;
    }
}