// 普通 O(n^2) 方法，44ms，32%
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int ans = 0;
        int n = nums.size();
        vector<int> maxLen(n);
        for (int i = n - 1; i >= 0; --i) {
            int tmpMax = 0;
            for (int j = n - 1; j > i; --j) {
                if (nums[j] > nums[i]) {
                    tmpMax = tmpMax > maxLen[j] + 1 ? tmpMax : maxLen[j] + 1;
                }
            }
            maxLen[i] = tmpMax;
            ans = ans > tmpMax + 1 ? ans : tmpMax + 1;
        }
        return ans;
    }
};
