// 关键是理解为什么状态转移方程是正确的
// w1插入相当于w1尾部插入，w1删除相当于w2尾部插入，w1替换相当于w1和w2同时在尾部插入
// if w1[i] == w2[j], dp[i][j] = dp[i-1][j-1]
// else dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
class Solution {
public:
    int minDistance(string word1, string word2) {
        int n1 = word1.size(), n2 = word2.size();
        vector<vector<int>> dp(n1 + 1, vector<int>(n2 + 1, 0));
        for (int i = 1; i <= n1; ++i) dp[i][0] = i; // 初始状态
        for (int j = 1; j <= n2; ++j) dp[0][j] = j;
        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                if (word1[i - 1] == word2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[n1][n2];
    }
};