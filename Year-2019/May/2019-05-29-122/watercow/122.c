// 峰谷法 O(n)
// 连续上升的就可以一直屯入
// 遇到“谷”，就卖出“谷”前的“峰”，然后买入“谷”

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		if (prices.size() == 0) return 0;

		int cur = prices[0];
		int ret = 0;

		for (auto price : prices) {
			if (price > cur) {
				ret += price - cur;
			}
			cur = price;
		}
		return ret;
	}
};
