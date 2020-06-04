class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> left(nums.size());
        vector<int> right(nums.size());
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (i == 0) left[i] = nums[i];
            else left[i] = left[i - 1] * nums[i];
            if (i == 0) right[n - 1 - i] = nums[n - 1 - i];
            else right[n - 1 - i] = right[n - i] * nums[n - 1 - i];
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            if (i == 0) ans[i] = right[i + 1];
            else if (i == n - 1) ans[i] = left[i - 1];
            else ans[i] = left[i - 1] * right[i + 1];
        }
        return ans;
    }
};