// dp[i]:来到第i天的最小花费
// dp[i] = min{ dp[i-1] + costs[0], dp[i-7] + costs[1], dp[i-30] + costs[2] }
class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        const int INF = 0x3f3f3f3f;
        int daysSize = days.size(), n = days[days.size() - 1];
        vector<int> dp(n + 1, 0); // dp[i]:来到第i天的最小花费
        for (int i = 0; i < days.size(); ++i) {
            dp[days[i]] = -1; // 旅行的天
        }
        for (int i = 1; i <= n; ++i) {
            if (dp[i] == 0) dp[i] = dp[i - 1];
            else {
                int c1 = dp[i - 1] + costs[0];
                int c2 = ((i >= 7) ? dp[i - 7] : 0) + costs[1];
                int c3 = ((i >= 30) ? dp[i - 30] : 0) + costs[2];
                dp[i] = min(c1, min(c2, c3));
            }
        }
        return dp[n];
    }
};