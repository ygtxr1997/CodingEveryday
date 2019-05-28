// dp[i][j]表示以第i行第j列元素为正方形右下角元素时的最大边长
// dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) 

class Solution {
public:
	int maximalSquare(vector<vector<char>>& matrix) {
		if (matrix.size() == 0) return 0;
		vector<vector<int>> dp(matrix.size() + 1, vector<int>(matrix[0].size() + 1, 0));

		int max_ = 0;

		for (int i = 1; i <= matrix.size(); i++) {
			for (int j = 1; j <= matrix[0].size(); j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1]));
					max_ = max(dp[i][j], max_);
				}
			}
		}

		return max_ * max_;
	}
};
