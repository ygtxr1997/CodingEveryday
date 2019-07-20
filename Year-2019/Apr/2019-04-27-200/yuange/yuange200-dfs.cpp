// 简单的dfs,12ms,94%
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;
        int n = grid.size(), m = grid[0].size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ans += dfs(grid, i, j);
            }
        }
        return ans;
    }
    
    int dfs(vector<vector<char>>& grid, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) return 0;
        if ('1' == grid[i][j]) {
            grid[i][j] = '2';
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            return 1;
        } else {
            return 0;
        }
    }
};
