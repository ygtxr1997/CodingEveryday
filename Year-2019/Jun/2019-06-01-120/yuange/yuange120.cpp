// 4ms, 97%
// 直接dfs会超时，要用dp
// 从下向上遍历，直接在triangle上修改，会更简便
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int res = 0x7fffffff;
        vector<vector<int>> dp;
        for (auto vec : triangle) dp.push_back(vector<int>(vec.size()));
        dp[0][0] = triangle[0][0];
        if (dp.size() == 1) return dp[0][0];
        for (int i = 1; i < dp.size(); ++i) {
            for (int j = 0; j < dp[i].size(); ++j) {
                int a = j >= 1 ? dp[i - 1][j - 1] : 0x7fffffff;
                int b = j < i ? dp[i - 1][j] : 0x7fffffff;
                dp[i][j] = min(a, b) + triangle[i][j];
                if (i == dp.size() - 1) res = min(dp[i][j], res);
            }
        }
        return res;
    }
    
};