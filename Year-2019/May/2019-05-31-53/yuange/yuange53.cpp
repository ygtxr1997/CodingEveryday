// 4ms, 98%
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = -0x7fffffff;
        int sum = 0;
        for (auto num : nums) {
            sum += num;
            res = max(res, sum);
            if (sum <= 0) sum = 0;
        }
        return res;
    }
};