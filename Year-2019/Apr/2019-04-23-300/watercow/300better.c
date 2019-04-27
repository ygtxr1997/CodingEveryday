// 超级经典的题目 LIS
// O(nlogn)
// https://blog.csdn.net/shuangde800/article/details/7474903

class Solution {
public:
	int lengthOfLIS(vector<int>& nums) {
		if (nums.size() == 0) return 0;

		int maxLen = 0;
		vector<int> dp(nums.size(), 0);
		for (int i = 0; i < nums.size(); i++){
			int low = 0, high = maxLen;

			// 二分法检索要插入的位置
			while (low < high) {
				int mid = low + (high - low) / 2;

				if (dp[mid] < nums[i]) {
					low = mid + 1;
				}
				else high = mid;
			}

			// low即是要插入的位置
			dp[low] = nums[i];

			if (low >= maxLen) maxLen++;
		}
		return maxLen;
	}
};
