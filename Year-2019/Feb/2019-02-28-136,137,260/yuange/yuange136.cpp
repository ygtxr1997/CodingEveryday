class Solution {
public:
	int singleNumber(vector<int>& nums) {
		int res = 0;
		int n = nums.size();
		for (int i = 0; i < n; ++i)
			res ^= nums[i];
		return res;
	}
};