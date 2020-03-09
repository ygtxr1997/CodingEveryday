// 从b上车，c下车，那么只需要更新dp[b]~dp[c-1]的值，12ms，88%
class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<int> dp(1001, 0);
        int n = trips.size();
        for (int i = 0; i < n; ++i) {
            int a = trips[i][0], b = trips[i][1], c = trips[i][2];
            for (int j = b; j < c; ++j) {
                dp[j] += a;
                if (dp[j] > capacity) return false;
            }
        }
        return true;
    }
};