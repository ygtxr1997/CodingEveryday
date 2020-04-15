// bfs，时间较慢
class Solution {
private:
    const int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    const int INF = 0x3f3f3f3f;
    typedef pair<int, int> pii;
    typedef pair<pii, int> piii;
    int n, m;
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        n = matrix.size(), m = matrix[0].size();
        vector<vector<int>> ret(n, vector<int>(m, INF));
        for (int i = 0; i < n; ++i) for (int j = 0; j < m; ++j) if (matrix[i][j] == 0) ret[i][j] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] != 0) bfs(i, j, matrix, ret);
            }
        }
        return ret;
    }
    
    int bfs(int i, int j, vector<vector<int>>& M, vector<vector<int>>& ret) {
        int step = 0, finded = 0;
        queue<piii> qu;
        qu.push(piii(pii(i, j), 0));
        while (!finded && !qu.empty()) {
            int x = qu.front().first.first, y = qu.front().first.second;
            step = qu.front().second;
            qu.pop();
            step++;
            for (int op = 0; op < 4; ++op) {
                int n_x = x + dir[op][0], n_y = y + dir[op][1];
                if (n_x >= 0 && n_x < n && n_y >= 0 && n_y < m) {
                    if (M[n_x][n_y] == 0) { finded = 1; break; }
                    else qu.push(piii(pii(n_x, n_y), step));
                }
            }
        }
        ret[i][j] = step;
        return ret[i][j];
    }
};