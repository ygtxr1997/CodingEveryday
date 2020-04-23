// 方法一、动态规划
// dp[i][val]:只选前i种硬币达到总价值为val的总方法数
// 设k为第i种硬币选择的个数，则有：
// dp[i][val] = dp[i-1][val-0*cho[i]] + dp[i-1][val-1*cho[i]] + ... + dp[i-1][val-k*cho[i]] ------(1)
// 设val=val-cho[i]代入上式，可得
// dp[i][val-cho[i]] = dp[i-1][val-1*cho[i]] + ... + dp[i-1][val-k*cho[i]]                  ------(2)
// 由(1)(2)，得到优化后的状态转移方程
// dp[i][val] = dp[i-1][val] + dp[i][val-cho[i]] (k被消掉了)                                  
class Solution {
    int cho[4] = {1, 5, 10, 25};
public:
    int waysToChange(int n) {
        const int mod = 1000000007;
        const int maxn = 1000010;
        typedef long long ll;
        ll dp[maxn], last[maxn];
        memset(dp, 0, sizeof(dp));
        memset(last, 0, sizeof(last));
        for (int v = 0; v <= n; ++v) last[v] = 1;
        for (int i = 1; i < 4; ++i) {
            memset(dp, 0, sizeof(dp));
            for (int v = 0; v <= n; ++v) {
                if (v >= cho[i]) dp[v] = (last[v] + dp[v - cho[i]]) % mod;
                else dp[v] = last[v];
            }
            memcpy(last, dp, sizeof(last));
        }
        return dp[n];
    }
};