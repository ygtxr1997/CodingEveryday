// dp[i][j]:从0~i，有j个逆序对的数组个数
// dp[i][j]   =            dp[i-1][j-1]+dp[i-1][j-2]+... +dp[i-1][j-i+1]
// dp[i][j+1] = dp[i-1][j]+dp[i-1][j-1]+...+dp[i-1][j-i+2]
// dp[i][j] = dp[i][j-1] + dp[i-1][j-1] - dp[i-1][j-i]
class Solution {
public:
    int kInversePairs(int n, int k) {
        int dp[1001][1001] = { 0 };
        if (k > n * (n - 1) / 2 || k < 0) return 0; // 不存在这样的数组
        if (k == 0 || k == n * (n - 1) / 2) return 1; // 全正或全反
        const int mod = 1e9 + 7;
        dp[2][0] = dp[2][1] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= min(k, n * (n - 1) / 2); ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] % mod + mod) % mod;
            }
        }
        return dp[n][k];
    }
};