// 14ms, 12%
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int minLen = 0x6fffffff;
        string ret;
        if (strs.size() < 1) return "";
        for (auto str : strs) minLen = minLen < strs.size() ? minLen : str.size();
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0][i];
            for (auto str : strs) {
                if (str[i] != c) return ret;
            }
            ret.push_back(c);
        }
        return ret;
    }
};