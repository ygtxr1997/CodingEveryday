// 记录能走最远的那个nums[m]
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size(), m = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > nums[m] - (i - m)) m = i;
            if (nums[i] == 0 && nums[m] <= (i - m)) return false;
        }
        return true;
    }
};