// 两个向右走的指针，20ms，94%
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 2) return nums.size();
        int j = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[j] != nums[i]) nums[++j] = nums[i];
        }
        return j + 1;
    }
};