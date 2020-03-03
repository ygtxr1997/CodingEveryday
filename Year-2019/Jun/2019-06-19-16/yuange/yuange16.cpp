// O(n^2)，4ms，99%
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ans = 0, dif = 0x7fffffff;
        for (int i = 0; i < nums.size() - 2; ++i) {
            int j = i + 1, k = nums.size() - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (abs(sum - target) < dif) {
                    ans = sum;
                    dif = abs(sum - target);
                    if (dif == 0) return ans;
                }
                if (nums[j] + nums[k] < target - nums[i]) j++;
                else k--;
            }
        }
        return ans;
    }
};