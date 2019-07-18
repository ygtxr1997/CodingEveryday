// 32ms, 98%
// dp[i][j] = 以第(i, j)个元素开始的最长递增路径的长度
class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if (matrix.empty()) return 0;
        int n = matrix.size(), m = matrix[0].size();
        vector<vector<int>> dp(n, vector<int>(m));
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int res = dfs(matrix, dp, i, j, -1);
                ans = ans > res ? ans : res;
            }
        }
        return ans;
    }
    
    // 上下左右四个方向搜索,会把搜索路径上所有节点的dp值都更新
    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j, int cur) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix[0].size()) return 0;
        if (matrix[i][j] > cur) {
            if (dp[i][j] == 0) {
                int l = dfs(matrix, dp, i, j - 1, matrix[i][j]) + 1;
                int r = dfs(matrix, dp, i, j + 1, matrix[i][j]) + 1;
                int u = dfs(matrix, dp, i - 1, j, matrix[i][j]) + 1;
                int d = dfs(matrix, dp, i + 1, j, matrix[i][j]) + 1;
                l = l > r ? l : r;
                u = u > l ? u : l;
                d = d > u ? d : u;
                dp[i][j] = d;
            }
            return dp[i][j];
        }
        return 0;
    }
};
