class Solution {
public:
	vector<vector<int>> merge(vector<vector<int>>& intervals) {
		vector<vector<int>> ret;

		// 先以[0]位置的大小进行排序
		sort(intervals.begin(), intervals.end(), cmp);

		for (int i = 0; i < intervals.size(); i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];

			for (; i < intervals.size() - 1 && right >= intervals[i + 1][0]; i++) {
				right = max(right, intervals[i + 1][1]);
			}

			ret.push_back({ left, right });
		}

		return ret;
	}

	static bool cmp(vector<int>& a, vector<int>& b) {
		return a[0] < b[0];
	}
};
