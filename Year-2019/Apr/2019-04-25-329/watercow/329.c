// DFS + DP
// 设dp[i][j]表示让第i行第j列的单元作为起始节点可以得到的最长长度值
// 从matrix[0][0]出发，依次使用dfs遍历上下左右四个方向；
// 当遇到dp[x][y]已经计算过的情况后可以直接返回结果

class Solution {
public:

	int longestIncreasingPath(vector<vector<int>>& matrix) {
		if (matrix.size() == 0) return 0;

		vector<vector<int>> dp(matrix.size(), vector<int>(matrix[0].size(), 0));

		int result = 0;
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix[0].size(); j++) {
				result = max(result, dfs(matrix, dp, i, j, -1));
			}
		}

		return result;
	}

private:

	int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j, int lastvalue) {
		if (i < 0 || i >= matrix.size() - 1) return 0;
		if (j < 0 || j >= matrix[0].size() - 1) return 0;

		if (matrix[i][j] > lastvalue) {
			if (dp[i][j] != 0) return dp[i][j];
			int left = dfs(matrix, dp, i, j - 1, matrix[i][j]) + 1;
			int right = dfs(matrix, dp, i, j + 1, matrix[i][j]) + 1;
			int up = dfs(matrix, dp, i - 1, j, matrix[i][j]) + 1;
			int down = dfs(matrix, dp, i + 1, j, matrix[i][j]) + 1;

			dp[i][j] = max(left, max(right, max(up, down)));
			return dp[i][j];
		}
		return 0;
	}

};
