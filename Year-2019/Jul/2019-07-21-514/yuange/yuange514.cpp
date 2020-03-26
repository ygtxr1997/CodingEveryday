// dp[i][j]:指针在ring[i]，且ring[i]==key[j]，匹配key中[0~j-1]的部分，这种情况下的最优结果
// dp[i][j] = min(dp[i][j], dp[k][j-1] + min(|k-i|, ring.size-|k-i|))
// dp[i][0]易知
class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int step = INT_MAX;
        vector<vector<int>> dp(ring.size(), vector<int>(key.size(), INT_MAX));
        for (int j = 0; j < key.size(); ++j) {
            for (int i = 0; i < ring.size(); ++i) {
                if (ring[i] == key[j]) {
                    if (j == 0) dp[i][0] = i < ring.size() - i ? i : ring.size() - i;
                    else {
                        for (int k = 0; k < ring.size(); k++) {
                            if (dp[k][j - 1] != INT_MAX) {
                                int tmp = dp[k][j - 1] + 
                                    (abs(k - i) < ring.size() - abs(k - i) ?
                                    abs(k - i) : ring.size() - abs(k - i));
                                dp[i][j] = dp[i][j] < tmp ? dp[i][j] : tmp;
                            }
                        }
                    }
                    if (j == key.size() - 1) step = step < dp[i][j] ? step : dp[i][j];
                }
            }
        }
        return step + key.size();
    }
};