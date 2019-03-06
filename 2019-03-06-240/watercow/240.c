// 从右上角开始(右上角数字是该行最大 该列最小的元素)
// 1）== target: return
// 2) > target: 去掉该数所在列
// 3) < target: 去掉该数所在行
// 4) 直到最后的区域为空
class Solution {
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		if (matrix.empty()) return false;

		int col = matrix.size(), row = matrix[0].size();
		for (int i = 0, j = row - 1; i < col && j >= 0; ) {
			if (target > matrix[i][j]) i++;
			else if (target < matrix[i][j]) j--;
			else return true;
		}
		return false;
	}
};