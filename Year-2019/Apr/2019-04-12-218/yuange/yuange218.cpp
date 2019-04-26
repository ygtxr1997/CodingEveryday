// 一个比较简洁的思路，44ms，40%
// 把每栋房子看作矩形，首先把矩形(Li，-Hi)和(Ri，Hi)插入到multiset st中，自动排序
// 遍历multiset st，同时用另一个multiset height保存当前位置左边的历史高度，height.rbegin()即其最大值
// 遍历过程中，如果发现是Li，则插入到height，否则是Ri，删除Ri在height中对应的Li
// 如果height的最大值发生了变化，则该i元素就是返回结果之一
class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        if (buildings.empty()) return {};
        multiset<pair<int, int>> st;
        for (auto b : buildings) {
            st.insert(make_pair(b[0], -b[2]));
            st.insert(make_pair(b[1], b[2]));
        }
        vector<vector<int>> ret;
        multiset<int> height{0};
        int m = 0;
        for (auto s : st) {
            if (s.second < 0) height.insert(-s.second); // 矩形左侧
            else height.erase(height.find(s.second)); // 矩形右侧
            if (m != *height.rbegin())
                ret.push_back({s.first, *height.rbegin()});
            m = *height.rbegin();
        }
        return ret;
    }
};
