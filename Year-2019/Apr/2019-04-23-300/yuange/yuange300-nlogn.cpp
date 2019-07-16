// 贪心法结合二分查找,0ms,100%
// 感谢 STL 提供的二分查找
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> cache;
        for (int i : nums) {
            if (cache.empty() || cache.back() < i) cache.push_back(i);
            else *(lower_bound(cache.begin(), cache.end(), i)) = i;
        }
        return cache.size();
    }
};
