// 直接生成就行
// nums[i][j] = nums[i-1][j-1] + nums[i-1][j]

class Solution {
public:
	vector<vector<int>> generate(int numRows) {
		vector<vector<int>> res = {};

		if (numRows == 0) return res;
		res.push_back(vector<int>(1, 1));

		for (int i = 1; i < numRows; i++) {
			vector<int> curRow = vector<int>(i + 1, 1);
			vector<int> preRow = res[i - 1];

			for (int j = 1; j < i; j++) {
				curRow[j] = preRow[j - 1] + preRow[j];
			}

			res.push_back(curRow);
		}

		return res;
	}
};
