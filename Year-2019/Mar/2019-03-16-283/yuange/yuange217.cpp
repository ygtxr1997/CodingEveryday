// 用翻转，思路更简洁，速度更快
// z: 连续为0的第一个数字
// c: 连续不为0的长度
// m: 连续为0的长度
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        // 找到第一组0的位置
        int n = nums.size();
        int z = 0, m = 0;
        while (z < n && nums[z] != 0) z++;
        while (z + m < n) {
            int c = 0;
            while ((z + m) < n && nums[z + m] == 0) m++;
            while ((z + m + c) < n && nums[z + m + c] != 0) c++;
            reverse(nums.begin() + z, nums.begin() + z + m + c);
            reverse(nums.begin() + z, nums.begin() + z + c);
            z = z + c;
        }
        
    }
};
