// 16ms,97%
// 动态规划
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.empty()) return 0;
        int m = matrix.size(), n = matrix[0].size(); // m行n列
        int res = 0;
        vector<vector<int>> dp(m, vector<int>(n)); // 以(i,j)为正方形右下角的正方形的最大边长
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 仅当matrix[i][j]为1时更新dp[i][j]=min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]}+1
                if (matrix[i][j] == '1') {
                    int a = i >= 1 ? dp[i - 1][j] : 0;
                    int b = j >= 1 ? dp[i][j - 1] : 0;
                    int c = (i >= 1 && j >= 1) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = min(a, min(b, c)) + 1;
                    res = max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }
};