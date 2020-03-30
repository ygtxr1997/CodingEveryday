class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res(2);
        res[0] = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        res[1] = upper_bound(nums.begin(), nums.end(), target) - nums.begin() - 1;       
        return binary_search(nums.begin(), nums.end(), target) ? res : vector<int>(2, -1);
    }
};