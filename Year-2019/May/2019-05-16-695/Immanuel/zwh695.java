public class Solution{
    private int height;
    private int width;
    private int[][] matrix;
    private boolean[][] isVisited;
    
    private int getArea(int i, int j){
        if(isVisited[i][j]|| matrix[i][j] == 0)
            return 0;
        isVisited[i][j] = true;
        int outPut = 1;
        if(i < height - 1){
            outPut += getArea(i + 1, j);
        }
        if(i > 0){
            outPut += getArea(i - 1, j);
        }
        if(j < width - 1){
            outPut += getArea(i, j + 1);
        }
        if(j > 0){
            outPut += getArea(i, j - 1);
        }
        
        return outPut;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int outPut = 0;
        height = grid.length;
        width = grid[0].length;
        isVisited = new boolean[height][width];
        matrix = grid;
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                // if(matrix[i][j] == 1&& isVisited[i][j] == false){
                    outPut = Math.max(outPut, getArea(i, j));
                // }
            }
        }
        
        return outPut;
    }

}