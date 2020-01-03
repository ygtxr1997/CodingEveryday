// 96ms, 85%
// 用双指针，难点是去重
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int sum = -1;
        for (int i = 0; i < n && nums[i] <= 0; ++i) {
            int j = i + 1, k = n - 1;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    // sum 为 0
                    res.push_back(vector<int>({nums[i], nums[j], nums[k]}));
                    int nj = nums[j], nk = nums[k];
                    while (j < k && nums[++j] == nj);
                    while (j < k && nums[--k] == nk);
                }
            }
        }
        
        return res;
    }
};