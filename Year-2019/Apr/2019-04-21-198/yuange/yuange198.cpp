// 0ms,100%
// 动态规划递推公式:dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n);
        if (n < 1) return 0;
        if (n >= 1) dp[0] = nums[0];
        if (n >= 2) dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] > dp[i - 2] + nums[i] ? dp[i - 1] : dp[i - 2] + nums[i];
        }
        return dp[n - 1];
    }
};
