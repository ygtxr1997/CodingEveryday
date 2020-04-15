// 多起点BFS
class Solution {
private:
    typedef pair<int, int> pii;
    typedef pair<pii, int> piii;
    const int dir[4][2] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        queue<piii> qu;
        vector<vector<bool>> visited(n, vector<bool>(m, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    qu.emplace(piii(pii(i, j), 0));
                    visited[i][j] = 1;
                }
            }
        }
        vector<vector<int>> ret(n, vector<int>(m, INT_MAX));
        while (!qu.empty()) {
            int x = qu.front().first.first, y = qu.front().first.second;
            int step = qu.front().second;
            qu.pop();
            ret[x][y] = min(ret[x][y], step);
            for (int op = 0; op < 4; ++op) {
                int n_x = x + dir[op][0], n_y = y + dir[op][1];
                if (n_x >= 0 && n_x < n && n_y >= 0 && n_y < m && visited[n_x][n_y] == 0) {
                    qu.emplace(piii(pii(n_x, n_y), step + 1));
                    visited[x][y] = 1;
                }
            }
        }
        return ret;
    }
};