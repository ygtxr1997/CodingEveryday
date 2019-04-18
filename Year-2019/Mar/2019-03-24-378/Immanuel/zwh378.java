class Solution {
    private int countLorE(int[][] matrix, int middle){
        int count = 0;
        int n = matrix.length;
        int i = 0, j = n - 1;
        while (i < n&& j >= 0){
            if(matrix[i][j] > middle){
                j--;
            }
            else {
                count += j + 1;
                i++;
            }
        }

        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int bottom = matrix[0][0];
        int top = matrix[matrix.length - 1][matrix.length - 1];
        int middle = 0;
        while (bottom <= top) {
            middle = bottom + (top - bottom) / 2;
            int count = countLorE(matrix, middle);
            if(count < k){
                bottom = middle + 1;
            }
            else{
                top = middle - 1;
            }
        }

        return bottom;
    }
}