// 0ms，100%
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> cur;
        vector<vector<int>> vvec;
        trace(vvec, nums, 0, cur);
        return vvec;
    }
    
    void trace(vector<vector<int>>& vvec, vector<int>& nums, int k, vector<int>& cur) {
        if (k >= nums.size()) {
            vvec.push_back(cur);
            return;
        }
        trace(vvec, nums, k + 1, cur);
        cur.push_back(nums[k]);
        trace(vvec, nums, k + 1, cur);
        cur.pop_back();
    }
};