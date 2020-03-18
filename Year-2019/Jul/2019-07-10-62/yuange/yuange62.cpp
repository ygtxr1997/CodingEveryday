// 0ms，100%，实际上逐行遍历dp即可，不需要bfs
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> grid(n, vector<int>(m, -1));
        grid[0][0] = 1;
        queue<pair<int, int>> q; // <i, j>
        q.push(make_pair(0, 0));
        while (!q.empty()) {
            int a = q.front().first, b = q.front().second;
            q.pop();
            if (a + 1 < n && grid[a + 1][b] == -1) { q.push(make_pair(a + 1, b)); grid[a + 1][b] = 0; }
            if (b + 1 < m && grid[a][b + 1] == -1) { q.push(make_pair(a, b + 1)); grid[a][b + 1] = 0; }
            grid[a][b] += (a >= 1) ? grid[a - 1][b] : 0;
            grid[a][b] += (b >= 1) ? grid[a][b - 1] : 0;
        }
        return grid[n - 1][m - 1];
    }
};