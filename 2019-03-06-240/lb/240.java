public class SearchMatrix {
    /**
     * 对每一行循环，每次循环修改下次循环的长度的，减少查询的次数
     * 但对于右下角的target需要循环数组的所有数
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int end = matrix[0].length;
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<end;j++){
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target){
                    end = j;//j和之后的数都比target大，修改下次循环的次数
                    break;
                }
            }
        }
        return false;
    }
}
