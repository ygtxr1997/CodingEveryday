// 最长递增子序列dp+二分查找
class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if (envelopes.empty()) return 0;
        sort(envelopes.begin(), envelopes.end(), cmp);
        vector<int> dp{ envelopes[0][1] }; // 以第i个信封结尾的最大信封个数
        for (int i = 0; i < envelopes.size(); ++i) {
            auto it = lower_bound(dp.begin(), dp.end(), envelopes[i][1]);
            if (it == dp.end()) dp.push_back(envelopes[i][1]);
            else *it = envelopes[i][1];
        }
        return dp.size();
    }

    static bool cmp(vector<int> a, vector<int> b) {
        if (a[0] == b[0]) return a[1] > b[1];
        return a[0] < b[0];
    }
};