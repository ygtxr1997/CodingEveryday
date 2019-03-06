#include <iostream>
#include <vector>
using namespace std;

/*
    注意事项：
    1.时刻注意检查边界
    2.从多个角度思考出发

*/

class Solution {
public:
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		int m = matrix.size();
		if (m == 0)
			return false;
		int n = matrix[0].size();
		if (n == 0)
			return false;
		int i{ };
		int j{ n - 1 };
		while (matrix[i][j] != target)
		{
			if (matrix[i][j] > target)
			{
				if (j == 0)
					return false;
				j--;
			}
			else
			{
				if (i == m - 1)
					return false;
				i++;
			}
		}
		return true;
	}
};


int main()
{
	Solution s;
	vector<vector<int>> matrix = {
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30}
	};
	cout << s.searchMatrix(matrix, 5);
}
