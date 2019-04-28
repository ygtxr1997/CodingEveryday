// 0-1背包的改进版
// 直接用动态规划即可
// 设dp[i]表示金额为i时所需最少coins数
// dp[i] = min(dp[i], dp[i-coin] + 1)
// WOC 注意coins是没有排序的，弄了好久
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX - 1);

        dp[0] = 0;
        sort(coins.begin(), coins.end());

        for(int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.size(); j++) {

                if (i - coins[j] < 0) break;
                dp[i] = min(dp[i], dp[i - coins[j]] + 1);

            }
        }
        if (dp[amount] == INT_MAX - 1) return -1;
        else return dp[amount];
    }
};
