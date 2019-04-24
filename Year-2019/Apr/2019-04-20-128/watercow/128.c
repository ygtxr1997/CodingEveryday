// https://blog.csdn.net/weixin_42289193/article/details/81736238
// https://www.bilibili.com/video/av44538768

// O(2n) = O(n)
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> num_set(nums.begin(), nums.end());
        int res = 0;
        for (int num: nums) {
            if (num_set.find(num - 1) == num_set.end()) {
                int cur_num = num;
                int cur_streak = 1;

                while (num_set.find(cur_num + 1) != num_set.end()) {
                    cur_num++;
                    cur_streak++;
                }
                res = max(res, cur_streak);
            }
        }
        return res;
    }
};
