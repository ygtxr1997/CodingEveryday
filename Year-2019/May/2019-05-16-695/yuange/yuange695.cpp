// 8ms, 99%
class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        if (grid.empty()) return 0;
        int res = 0;
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cur = 0;
                if (grid[i][j]) trace(grid, i, j, cur);
                res = cur > res ? cur : res;
            }
        }
        return res;
    }
    
    void trace(vector<vector<int>>& grid, int i, int j, int& s) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) return;
        if (!grid[i][j]) return;
        // 一块陆地
        s++;
        grid[i][j] = 0;
        // 四个方向
        trace(grid, i - 1, j, s);
        trace(grid, i, j + 1, s);
        trace(grid, i + 1, j, s);
        trace(grid, i, j - 1, s);
    }
};