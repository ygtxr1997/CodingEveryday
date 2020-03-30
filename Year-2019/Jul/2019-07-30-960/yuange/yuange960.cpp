// 应该可以用二分查找进一步优化
class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        if (A.empty()) return 0;
        int n = A.size(), m = A[0].size();
        int ans = 0; // 最长递增列的长度
        vector<int> dp(m, 1); // 以j列结尾的最长递增列的长度
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < j; ++k) {
                bool bBig = true; // 第k列全都小于等于第j列
                for (int i = 0; i < n; ++i) {
                    if (A[i][k] > A[i][j]) { bBig = false; break; }
                }
                if (bBig) {
                    dp[j] = max(dp[j], dp[k] + 1);
                }
            }
            ans = max(ans, dp[j]);
        }
        return m - ans;
    }
};