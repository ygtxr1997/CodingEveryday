// 垃圾dp方法，时间复杂度O(n*n*m)
class Solution {
public:
    int numDistinct(string s, string t) {
        int n = s.size(), m = t.size();
        if (n < m) return 0;
        // 记录s[0~i]范围内与t[j]相同的位置
        vector<vector<vector<int>>> pos(n, vector<vector<int>>(m, vector<int>()));
        for (int j = 0; j < m; ++j) {
            vector<int> tmp;
            for (int i = 1; i < n; ++i) {
                if (s[i] == t[j]) tmp.push_back(i);
                pos[i][j] = tmp;
            }
        }
        // dp[i][j]=SUM(dp[x-1][j-1]),s[x]==t[j]
        vector<vector<long>> dp(n, vector<long>(m, 0));
        int count_0 = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == t[0]) count_0++;
            for (int j = 0; j <= i && j < m; ++j) {
                if (j == 0) dp[i][0] = count_0;
                else {
                    for (int x : pos[i][j]) {
                        dp[i][j] += dp[x - 1][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }
};