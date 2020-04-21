// 找到每个奇数的位置, 再根据奇数出现的位置算出连续k个奇数子数组的个数
class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> pos;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2) pos.push_back(i);
        }
        for (int j = 0; j + k - 1 < pos.size(); ++j) {
            int left, right;
            left = (j > 0) ? pos[j] - pos[j - 1] - 1 : pos[j];
            right = (j + k - 1 < pos.size() - 1) ? pos[j + k] - pos[j + k - 1] - 1 : n - pos[j + k - 1] - 1;
            ans += (left + 1) * (right + 1);
        }
        return ans;
    }
};