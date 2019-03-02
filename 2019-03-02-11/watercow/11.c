class Solution {
public:
	int maxArea(vector<int>& height) {
		int max_res = 0, h;
		int left = 0, right = height.size() - 1;
		while (left < right) {
			h = min(height[left], height[right]);
			max_res = max(max_res, h * (right - left));

			if (height[left] < height[right]) left++;
			else right--;
		}
		return max_res;
	}
};