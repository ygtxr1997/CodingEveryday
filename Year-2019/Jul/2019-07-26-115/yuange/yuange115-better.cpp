// 相对于垃圾方法，选择了更短的t字符串保存其所有字母的位置，时间复杂度O(n*m*m)
class Solution {
public:
    int numDistinct(string s, string t) {
        int n = s.size(), m = t.size();
        if (n < m) return 0;
        // 记录s每个字母的所有位置
        unordered_map<char, vector<int>> pos;
        for (int j = 0; j < m; ++j) pos[t[j]].push_back(j);
        // if s[i]==t[j], dp[i][j]=SUM(dp[i-1][x-1]),s[i]==t[x]
        // if s[i]!=t[j], dp[i][j]=dp[i-1][j]
        vector<long> dp(m, 0);
        int count_0 = 0;
        for (int i = 0; i < n; ++i) {
            auto ite = pos.find(s[i]);
            if (ite == pos.end()) continue;
            vector<int>& pvec = ite->second;
            for (int x = pvec.size() - 1; x >= 0; --x) {  
                if (pvec[x] == 0) dp[0] = ++count_0;
                else if (i >= 1) dp[pvec[x]] += dp[pvec[x] - 1];
            }
        }
        return dp[m - 1];
    }
};