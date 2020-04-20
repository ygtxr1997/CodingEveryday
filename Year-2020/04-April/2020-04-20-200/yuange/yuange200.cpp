class Solution {
public:
    int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    typedef pair<int, int> pii;
    void bfs(int i, int j, vector<vector<char>>& g) {
        int n = g.size(), m = g[0].size();
        queue<pii> qu;
        qu.push(pii(i, j));
        while (!qu.empty()) {
            int x = qu.front().first, y = qu.front().second;
            qu.pop();
            for (int op = 0; op < 4; ++op) {
                int n_x = x + dir[op][0], n_y = y + dir[op][1];
                if (n_x >= 0 && n_x < n && n_y >= 0 && n_y < m && g[n_x][n_y] == '1') {
                    g[n_x][n_y] = '0';
                    qu.push(pii(n_x, n_y));
                }
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) return 0;
        int n = grid.size(), m = grid[0].size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
};