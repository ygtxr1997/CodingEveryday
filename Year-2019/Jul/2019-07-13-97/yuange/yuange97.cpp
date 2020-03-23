// dfs和bfs都会超时，考虑使用dp，4ms，75%
// dp[i][j]代表s1[0~i-1]与s2[0~j-1]能否组成s3[0~i+j-1]
// dp[i][j]=(dp[i-1][j]&&s1[i-1]==s3[i+j-1]||dp[i][j-1]&&s2[j-1]==s3[i+j-1])
class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.size() + s2.size() != s3.size()) return false;
        int n1 = s1.size(), n2 = s2.size();
        vector<vector<bool>> dp(n1 + 1, vector<bool>(n2 + 1, 1));
        for (int i = 1; i <= n1; ++i) dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1];
        for (int j = 1; j <= n2; ++j) dp[0][j] = dp[0][j - 1] && s2[j - 1] == s3[j - 1];
        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1])
                    || (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]);
            }
        }
        return dp[n1][n2];
    }
};