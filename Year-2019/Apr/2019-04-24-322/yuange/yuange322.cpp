// 33ms,88%
// 动态规划，状态转移方程：dp[i] = min{dp[j] + 1}
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (auto c : coins) {
                if (i - c >= 0) dp[i] = min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
};
