class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.empty()) return -1;
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (target == nums[m]) return m;
            // 选取左边部分[l, m]时，注意等号
            if ((nums[m] > nums[0] && target <= nums[m] && target >= nums[0])
               || (nums[m] < nums[0] && target <= nums[m])
               || (nums[m] < nums[0] && target >= nums[0])) {
                r = m;
            } else {
                l = m + 1; // 选取右边[m+1, r]
            }
        }
        return nums[l] == target ? l : -1;
    }
};