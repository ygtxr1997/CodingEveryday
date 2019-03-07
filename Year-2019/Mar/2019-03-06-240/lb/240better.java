public class SearchMatrixBetter {
    /**
     * 分治法，根据左下角（或右上角）的值与target对比来减少一行或者一列或直接返回直到数组的大小为空
     * O（m+n）
     * 因为可以稳定的减少一行或一列的数据，所以比循环每一行的算法复杂度要低
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int row = matrix.length-1;
        int column = 0;
        //左下角
        while(row >=0 && column < matrix[0].length){
            if (matrix[row][column] == target)
                return true;
            if (matrix[row][column]>target)
                row --;
            else
                column ++;
        }
        return false;
    }
}
