// 快慢指针
// https://leetcode-cn.com/problems/duplicate-zeros/solution/kuai-man-zhi-zhen-by-jerring/
class Solution {
public:
	void duplicateZeros(vector<int>& arr) {
		int n = arr.size();
		int i = 0, j = 0;
		while (j < n) {
			if (arr[i] == 0) j++;
			i++; j++;
		}

		i--; j--;
		while (i >= 0) {
			if (j < n) arr[j] = arr[i];
			if (arr[i] == 0) arr[--j] = arr[i];
			i--;
			j--;
		}
	}
};
