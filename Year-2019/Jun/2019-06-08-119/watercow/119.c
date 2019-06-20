class Solution {
public:
	vector<int> getRow(int rowIndex) {
		if (rowIndex == 0) return {1};

		vector<int> res(1, 1); // 初始化第0行元素
		vector<int> pre;

		for (int i = 1; i <= rowIndex; i++) {
			pre.assign(res.begin(), res.end());
			for (int j = 1; j < i; j++) {
				res[j] = pre[j - 1] + pre[j];
			}
			res.push_back(1);
		}
		return res;
	}
};
