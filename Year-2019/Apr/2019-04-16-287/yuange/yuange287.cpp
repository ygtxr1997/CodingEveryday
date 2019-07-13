// 正负标记法,12ms,92.65%
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        for (int i : nums) {
            if (nums[abs(i) - 1] < 0) return abs(i);
            else nums[abs(i) - 1] = -nums[abs(i) - 1];
        }
        return 1;
    }
};
