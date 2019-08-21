class Solution {
    int rowSize;
    int colSize;
    int[][] grid;
    
    private int dfs(int rowIndex, int colIndex){
        if(rowIndex >= rowSize || colIndex >= colSize)
            return 0;
        
        if(grid[rowIndex][colIndex] == 0){
            grid[rowIndex][colIndex] = dfs(rowIndex + 1, colIndex) + dfs(rowIndex, colIndex + 1);
        }
        return grid[rowIndex][colIndex];
    }
    
    public int uniquePaths(int m, int n) {
        rowSize = m;
        colSize = n;
        grid = new int[rowSize][colSize];
        grid[rowSize - 1][colSize - 1] = 1;
            
        return dfs(0, 0);
    }
    
//公式法， C(m, m + n)
//     public int uniquePaths(int m, int n) {
//         if(m * n == 0) return 0;
//         if(m == 1||n == 1) return 1;
        
//         m--;
//         n--;
//         if(m < n){
//             m = m + n;
//             n = m - n;
//             m = m - n;
//         }
        
//         long outPut = 1;
//         for(int i = 1; i <= n; i++){
//             outPut *= m + i;
//         }
//         for(int i = n; i > 0; i--){
//             outPut /= i;
//         }
        
//         return (int)outPut;
//     }

}