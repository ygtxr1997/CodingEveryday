// 最简洁的思路，一次性移动
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int i = 0, j = 0;
        for (int i = 0; i < n; ++i)
            if (nums[i] != 0) nums[j++] = nums[i];
        while (j < n) nums[j++] = 0;
    }
};
