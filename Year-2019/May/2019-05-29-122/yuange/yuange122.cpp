// 8ms, 61%
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.empty()) return 0;
        int  l = 0, r = 0;
        int res = 0;
        for (int i = 0; i < prices.size() - 1;) {
            while (i < prices.size() - 1 && prices[i + 1] <= prices[i]) i++;
            l = i;
            while (i < prices.size() - 1 && prices[i + 1] > prices[i]) i++;
            r = i;
            int cur = prices[r] - prices[l];
            res += cur > 0 ? cur : 0;
        }
        return res;
    }
};