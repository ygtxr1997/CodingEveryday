class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int rowSize = grid.length;
        int colSize = grid[0].length;
        if(grid[0][0] == 1 || grid[rowSize - 1][colSize - 1] == 1)
            return -1;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1,-1}, {-1, 1}, {1,-1}};
        int length = 1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!que.isEmpty()){
            int size = que.size();
            while (size-- > 0){
                int[] pos = que.poll();
                if(pos[0] == rowSize - 1 && pos[1] == colSize - 1)
                    return length;
                for(int[] dir: directions){
                    int rowIndex = pos[0] + dir[0];
                    int colIndex = pos[1] + dir[1];
                    if(rowIndex >= 0 && rowIndex < rowSize && colIndex >= 0 && colIndex < colSize && grid[rowIndex][colIndex] == 0){
                        grid[rowIndex][colIndex] = 1;
                        que.offer(new int[]{rowIndex, colIndex});
                    }
                }
            }
            length++;
        }
        
        return -1;
    }
}


//TLE，冗余计算过多，应当使用一个队列来做BFS，而且对8个方向的处理也不好
// class Solution {
//     int rowSize, colSize;
//     int[][] grid;
//     int[][] path;
    
//     private boolean isReachable(int rowIndex, int colIndex){
//         return rowIndex >= 0 && rowIndex < rowSize && colIndex >= 0 && colIndex < colSize && grid[rowIndex][colIndex] != 1;
//     }

//     private void dfs(int rowIndex, int colIndex){
//         if(isReachable(rowIndex - 1, colIndex) && path[rowIndex][colIndex] + 1 < path[rowIndex - 1][colIndex]){
//             path[rowIndex - 1][colIndex] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex - 1, colIndex);
//         }
//         if(isReachable(rowIndex + 1, colIndex) && path[rowIndex][colIndex] + 1 < path[rowIndex + 1][colIndex]){
//             path[rowIndex + 1][colIndex] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex + 1, colIndex);
//         }
//         if(isReachable(rowIndex, colIndex - 1) && path[rowIndex][colIndex] + 1 < path[rowIndex][colIndex - 1]){
//             path[rowIndex][colIndex - 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex, colIndex - 1);
//         }
//         if(isReachable(rowIndex, colIndex + 1) && path[rowIndex][colIndex] + 1 < path[rowIndex][colIndex + 1]){
//             path[rowIndex][colIndex + 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex, colIndex + 1);
//         }
//         if(isReachable(rowIndex - 1, colIndex - 1) && path[rowIndex][colIndex] + 1 < path[rowIndex - 1][colIndex - 1]){
//             path[rowIndex - 1][colIndex - 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex - 1, colIndex - 1);
//         }
//         if(isReachable(rowIndex + 1, colIndex + 1) && path[rowIndex][colIndex] + 1 < path[rowIndex + 1][colIndex + 1]){
//             path[rowIndex + 1][colIndex + 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex + 1, colIndex + 1);
//         }
//         if(isReachable(rowIndex - 1, colIndex + 1) && path[rowIndex][colIndex] + 1 < path[rowIndex - 1][colIndex + 1]){
//             path[rowIndex - 1][colIndex + 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex - 1, colIndex + 1);
//         }
//         if(isReachable(rowIndex + 1, colIndex - 1) && path[rowIndex][colIndex] + 1 < path[rowIndex + 1][colIndex - 1]){
//             path[rowIndex + 1][colIndex - 1] = path[rowIndex][colIndex] + 1;
//             dfs(rowIndex + 1, colIndex - 1);
//         }
//     }

//     public int shortestPathBinaryMatrix(int[][] grid) {
//         if(grid == null || grid.length == 0 || grid[0].length == 0)
//             return -1;

//         this.grid = grid;
//         rowSize = grid.length;
//         colSize = grid[0].length;
//         if(grid[rowSize - 1][colSize - 1] == 1)
//             return -1;

//         path = new int[rowSize][colSize];
//         for(int[] tmp: path){
//             Arrays.fill(tmp, Integer.MAX_VALUE);
//         }
//         path[rowSize - 1][colSize - 1] = 1;
//         dfs(rowSize - 1, colSize - 1);

//         return path[0][0] == Integer.MAX_VALUE? -1: path[0][0];
//     }
// }