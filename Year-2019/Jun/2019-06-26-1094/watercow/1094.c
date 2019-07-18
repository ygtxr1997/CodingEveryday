class Solution {
public:
	bool carPooling(vector<vector<int>>& trips, int capacity) {
		vector<int> cnt(1001, 0); // 表示每一站的乘客人数

		for (auto trip : trips) {
			cnt[trip[1]] += trip[0];
			cnt[trip[2]] -= trip[0];
		}

		if (cnt[0] > capacity) return false;
		for (int i = 1; i < 1001; i++) {
			cnt[i] += cnt[i - 1];
			if (cnt[i] > capacity) return false;
		}

		return true;
	}
};
