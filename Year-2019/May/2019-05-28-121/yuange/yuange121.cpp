// 8ms, 68%
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty()) return 0;
        int res = 0;
        int n = prices.size();
        int low = prices[0];
        for (int i = 1; i < n; ++i) {
            if (prices[i] < low) low = prices[i];
            else res = (prices[i] - low) > res ? prices[i] - low : res;
        }
        return res;
    }
};