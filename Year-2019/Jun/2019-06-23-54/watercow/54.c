class Solution {
public:
	vector<int> spiralOrder(vector<vector<int>>& matrix) {
		if (matrix.size() == 0) return {};
		if (matrix[0].size() == 0) return {};
		vector<int> res;

		int left = 0, top = 0, right = matrix[0].size() - 1, bottom = matrix.size() - 1;

		while (true) {
			// from left to right
			for (int i = left; i <= right; i++) {
				res.push_back(matrix[top][i]);
			}
			if (++top > bottom) break;

			// from top to bottom
			for (int i = top; i <= bottom; i++) {
				res.push_back(matrix[i][right]);
			}
			if (--right < left) break;

			// from right to left
			for (int i = right; i >= left; i--) {
				res.push_back(matrix[bottom][i]);
			}
			if (--bottom < top) break;

			// from bottom to top
			for (int i = bottom; i >= top; i--) {
				res.push_back(matrix[i][left]);
			}
			if (++left > right) break;
		}
		return res;
	}
};
