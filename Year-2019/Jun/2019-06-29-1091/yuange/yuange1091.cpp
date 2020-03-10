// dfs会超时，改用bfs，40ms，99%
// ele也可以直接用pair代替，res在每次while循环中自增即可
class Solution {
private:
    struct ele {
        ele (int a, int b, int c) : first(a), second(b), third(c) {}
        int first;  // i
        int second; // j
        int third;  // path
    };
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if (grid[0][0]) return -1;
        int minPath = INT_MAX;
        int M = grid.size();
        int N = grid[0].size();
        if (M == 1 && N == 1) return 1;
        int dic[8][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, 
                     {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue<ele> q; // <i, j, path>
        q.push(ele(0, 0, 1));
        grid[0][0] = 1;
        while(!q.empty()) {
            int i = q.front().first, j = q.front().second, pa = q.front().third;
            q.pop();
            for (int k = 0; k < 8; ++k) {
                int a = i + dic[k][0], b = j + dic[k][1];
                if (a < 0 || a >= M || b < 0 || b >= N) continue;
                if (grid[a][b] == 1) continue;
                if (a == M - 1 && b == N - 1) {
                    minPath = pa + 1 < minPath ? pa + 1: minPath;
                }
                grid[a][b] = 1;
                q.push(ele(a, b, pa + 1));
            }
        }
        
        return minPath != INT_MAX ? minPath : -1;
    }
};