// dp[x]:当前分数是x, 能获胜的概率
// 边界:dp[K~min(K+W-1,N)]=1.0
// dp[i]=1/W*(dp[i+1]+dp[i+2]+...+dp[i+W])
class Solution {
public:
    double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        vector<double> dp(K + W + 1);
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0; // 获胜条件
        }
        dp[K - 1] = 1.0 * min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            // 递推方程优化
            dp[i] = (dp[i + 1] / W) + dp[i + 1] - dp[i + W + 1] / W;
        }
        return dp[0];
    }
};