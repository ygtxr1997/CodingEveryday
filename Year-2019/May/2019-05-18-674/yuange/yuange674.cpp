// 16ms, 54%
class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        if (nums.empty()) return 0;
        int n = nums.size();
        int res = 1, cur = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) cur++;
            else {
                res = cur > res ? cur : res;
                cur = 1;
            }
        }
        return cur > res ? cur : res;
    }
};