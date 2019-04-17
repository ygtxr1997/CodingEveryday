// 4ms, 100%
class Solution {
public:
    int titleToNumber(string s) {
        int ret = 0;
        for (auto c : s) ret = ret * 26 + (c - 'A' + 1);
        return ret;
    }
};
