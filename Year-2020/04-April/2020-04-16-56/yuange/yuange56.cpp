// 先根据左端点排序，再用双指针遍历
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        vector<vector<int>> res;
        if (intervals.empty()) return res;
        int l = intervals[0][0], r = intervals[0][1];
        for (auto vec : intervals) {
            int a = vec[0], b = vec[1];
            if (a <= r) r = r > b ? r : b;
            else {
                res.push_back({l, r});
                l = a;
                r = b;
            }
        }
        res.push_back({l, r});
        return res;
    }
    
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[0] < b[0];
    }
};