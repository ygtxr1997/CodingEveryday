// 108ms, 44%
// 动态规划，状态转移方程: dp[n] = min(dp[n], dp[n - i * i] + 1);
class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n + 1, 0x3f3f3f);
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j * j <= i && i - j * j >= 0; ++j) {
                dp[i] = min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
};
