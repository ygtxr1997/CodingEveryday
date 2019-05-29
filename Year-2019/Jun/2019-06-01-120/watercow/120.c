// O(1)的空间复杂度就是不需要另外new空间
// 直接在triangle上动手脚

// 利用DP思想从底层向上遍历
// triangle[i][j] += min(triangle[i+1][j], triangle[i+1][j+1])

// triangle[0][0]就是返回结果

class Solution {
public:
	int minimumTotal(vector<vector<int>>& triangle) {
		int row = triangle.size();

		for (int i = row - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].size(); j++) {
				triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		return triangle[0][0];
	}
};
