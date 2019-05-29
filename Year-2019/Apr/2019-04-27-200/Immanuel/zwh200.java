public class Solution {
    char[][] map;
    int rowSize;
    int colSize;

    private void visit(int rowPos, int colPos){
        if(rowPos < 0|| rowPos >= rowSize|| colPos < 0|| colPos >= colSize|| map[rowPos][colPos] != '1')
            return;
        map[rowPos][colPos] = '0';
        visit(rowPos - 1, colPos);
        visit(rowPos + 1, colPos);
        visit(rowPos, colPos - 1);
        visit(rowPos, colPos + 1);
    }

    public int numIslands(char[][] grid) {
         map = grid;
         rowSize = grid.length;
         if(rowSize == 0)
             return 0;
         colSize = grid[0].length;

         int count = 0;
         for(int i = 0; i < rowSize; i++){
             for(int j = 0; j < colSize; j++){
                if(map[i][j] == '1'){
                    count++;
                    visit(i, j);
                }
             }
         }

         return count;
    }
}