// dp[i][j]：以i结尾的数组分割成j个连续子数组的最小的最大值
// dp[i][j]=min(max(dp[k][j-1], nums[k+1]+...+nums[i]), k∈[0,i-1])
// O(n*m*n)
class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        vector<vector<long>> dp(nums.size(), vector<long>(m, INT_MAX));
        vector<long> sum(nums.size(), 0);
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0) sum[i] = nums[i];
            else {
                sum[i] = sum[i - 1] + nums[i];
            }
            dp[i][0] = sum[i];
        }
        for (int i = 1; i < nums.size(); ++i) {
            for (int j = 1; j < m; ++j) {
                for (int k = 0; k < i; ++k) {
                    dp[i][j] = std::min(dp[i][j], std::max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[nums.size() - 1][m - 1];
    }
};