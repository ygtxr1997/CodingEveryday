// 看似简单，写起来也不容易
// 12ms，66%
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        multimap<int, int> mp;
        for (int i = 0; i < nums.size(); ++i) mp.insert(make_pair(nums[i], i));
        int a = 0, b = 0;
        for (auto i = mp.begin(); i != mp.end(); ++i) {
            auto j = mp.find(target - i->first);
            if (j != mp.end() && i != j) {
                a = i->second;
                b = j->second;
                break;
            }
        }
        return vector<int>({a, b});
    }
};