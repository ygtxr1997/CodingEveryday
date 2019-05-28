class Solution {
public:
	int maxSubArray(vector<int>& nums) {
		if (nums.size() == 0) return 0;

		return maxSubArray(nums, 0, nums.size() - 1);
	}

	int maxSubArray(vector<int>& nums, int left, int right) {
		if (left == right) return nums[left];

		int mid = (left + right) / 2;
		int leftmax = maxSubArray(nums, left, mid);
		int rightmax = maxSubArray(nums, mid + 1, right);

		// 考虑跨mid的情况
		int lsub = INT_MIN, rsub = INT_MIN, sum = 0;
		for (int i = mid; i >= left; i--) {
			sum += nums[i];
			lsub = max(sum, lsub);
		}

		sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			rsub = max(sum, rsub);
		}

		return max(rsub + lsub, max(leftmax, rightmax));
	}
};
