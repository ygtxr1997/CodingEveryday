// 8ms，96%
// 如果数组不存在比nums[i]小的数，就去逐个查找比它大的数
// 关键是要理解为什么两个循环的时间复杂度是O(n)
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> us(nums.begin(), nums.end());
        int n = nums.size();
        int res = 0;
        for (int i : nums) {
            int cur = 1;
            if (!us.count(i - 1)) {         // 用count()代替find()
                while (us.count(1 + i++)) cur++;
                res = res > cur ? res : cur;
            }
        }
        return res;
    }
};
