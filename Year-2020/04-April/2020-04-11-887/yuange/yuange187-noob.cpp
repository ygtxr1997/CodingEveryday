// 原始dp解法，O(N*N*K)，会超时
// dp[i][k]:一共i层楼, 有k个蛋, 最少要找多少次
//                     j楼蛋碎      j楼蛋不碎
// dp[i][k] = min{ max{dp[j][k-1], dp[i - j][k]} + 1 | 1 <= j <= i}
class Solution {
public:
    int superEggDrop(int K, int N) {
        int dp[10010][103];
        for (int i = 0; i <= N; ++i) dp[i][1] = i;
        for (int i = 1; i <= N; ++i) {
            for (int k = 2; k <= K; ++k) {
                int cur_min = INT_MAX;
                for (int j = 1; j <= i; ++j) {
                    cur_min = min(cur_min, 
                        max(dp[j - 1][k - 1], dp[i - j][k]) + 1);
                }
                dp[i][k] = cur_min;
            }
        }
        return dp[N][K];
    }
};