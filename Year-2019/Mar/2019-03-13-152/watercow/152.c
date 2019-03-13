class Solution {
public:
	int maxProduct(vector<int>& nums) {
		if (nums.size() == 1) return nums[0];

		int len = nums.size();
		vector<int> dp_max(len, 0), dp_min(len, 0);
		int result = INT_MIN;

		for (int i = 0; i < len; i++) {
			if (i == 0) {
				dp_max[i] = nums[i];
				dp_min[i] = nums[i];
			}
			else {
				dp_max[i] = max(dp_max[i - 1] * nums[i], max(dp_min[i - 1] * nums[i], nums[i]));
				dp_min[i] = min(dp_max[i - 1] * nums[i], min(dp_min[i - 1] * nums[i], nums[i]));
			}
			result = max(dp_max[i], result);
		}
		return result;
	}
};