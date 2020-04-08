// bfs模板题
class Solution {
private:
#define maxn 101
    bool visited[maxn][maxn] = { 0 };
    typedef pair<int, int> pii;
    const int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
public:
    inline bool isValid(int x, int y, int k) {
        cout << x << ' ' << y << ' ' << k;
        return ((x / 10) + (x % 10) + (y / 10) + (y % 10)) <= k;
    }

    int movingCount(int m, int n, int k) {
        int ans = 1;
        queue<pii> qu;
        qu.push(pii(0, 0));
        visited[0][0] = 1;
        while (!qu.empty()) {
            int x = qu.front().first, y = qu.front().second;
            qu.pop();
            for (int op = 0; op < 4; ++op) {
                int n_x = x + dir[op][0], n_y = y + dir[op][1];
                if (n_x >= 0 && n_x < m && n_y >= 0 && n_y < n 
                    && visited[n_x][n_y] == 0 && isValid(n_x, n_y, k)) {
                    qu.push(pii(n_x, n_y));
                    visited[n_x][n_y] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
};