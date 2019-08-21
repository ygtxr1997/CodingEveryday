class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> outPut = new ArrayList();
        int rowSize = matrix.length;
        if(rowSize == 0) return outPut;
        int columnSize = matrix[0].length;
        if(columnSize == 0) return outPut;


        int[][] matriSta = new int[rowSize][columnSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < columnSize; j++){
                matriSta[i][j] = 0;
            }
        }
        int count_t = rowSize * columnSize;


        int i = 0, j = 0;
        while(count_t > 0){
            while(j < columnSize&&matriSta[i][j] != 1){
                outPut.add(matrix[i][j]);
                matriSta[i][j] = 1;
                j++;
                count_t--;
            }
            j--;
            i++;
            while(i < rowSize&&matriSta[i][j] != 1){
                outPut.add(matrix[i][j]);
                matriSta[i][j] = 1;
                i++;
                count_t--;
            }
            i--;
            j--;
            while(j > -1&&matriSta[i][j] != 1){
                outPut.add(matrix[i][j]);
                matriSta[i][j] = 1;
                j--;
                count_t--;
            }
            j++;
            i--;
            while(i > -1&&matriSta[i][j] != 1){
                outPut.add(matrix[i][j]);
                matriSta[i][j] = 1;
                i--;
                count_t--;
            }
            i++;
            j++;
        }


        return outPut;
    }
}