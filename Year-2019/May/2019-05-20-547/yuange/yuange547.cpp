// 12ms, 99%
// 借助visited辅助数组,用广度优先搜索也可以实现
class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int c = 0;
        vector<int> visited(M.size());
        for (int i = 0; i < M.size(); ++i) {
            if (!visited[i]) {
                dfs(M, visited, i);
                c++;
            }
        }
        return c;
    }
    
    void dfs(vector<vector<int>>& M, vector<int>& visited, int i) {
        for (int j = 0; j < M.size(); ++j) {
            if (!visited[j] && M[i][j]) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
};