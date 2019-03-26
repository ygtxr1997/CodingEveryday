// 直接使用优先队列，究极慢，80ms，23%
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ret;
        multimap<int, int> pq;
        for (int i = 0; i < k; ++i) pq.insert(pair<int, int>(nums[i], i));
        if (!pq.empty()) ret.push_back(pq.rbegin()->first);
        for (int i = k; i < nums.size(); ++i) {
            multimap<int, int>::iterator ite;
            do {
                ite = pq.find(nums[i - k]);
            } while (ite->second != i - k);
            pq.erase(ite);
            pq.insert(pair<int, int>(nums[i], i));
            ret.push_back(pq.rbegin()->first);
        }
        return ret;
    }
};