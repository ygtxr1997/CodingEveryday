class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> us(nums.begin(), nums.end());
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int j = nums[i];
            int cur = 1;
            if (0 == us.count(j - 1)) {
                while (us.count(j + 1)) {
                    j++;
                    cur++;
                }
                res = max(res, cur);
            }
        }
        return res;
    }
};