class Solution {
public:
    int distinctSubseqII(string S) {
        int n = S.size(), mod = 1e9 + 7;
        vector<int> pos(1000, -1); // S[i]最后一次出现的位置
        vector<int> dp(n, 0);
        dp[0] = 2;
        pos[S[0]] = 0;
        for (int i = 1; i < n; ++i) {
            dp[i] = (dp[i - 1] * 2) % mod;
            int ite = pos[S[i]];            
            if (ite != -1) {
                // 递推方程好说，但这个ite>0的边界条件花了我一个多小时才发现TvT
                dp[i] = (dp[i] - ((ite > 0 ) ? dp[ite - 1] : 1) + mod) % mod;
            }
            pos[S[i]] = i;
        }
        return (dp[n-1] - 1) % mod;
    }
};