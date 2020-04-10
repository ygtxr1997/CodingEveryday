// 原地解法
class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        int l = 0, m = 0, r = 0;
        s.push_back(' ');
        while (r < n) {
            m = r;
            while (m < n && s[m] == ' ') m++;
            r = m;
            while (r < n && s[r] != ' ') r++;
            r++;
            reverse(s.begin() + m, s.begin() + r);
            reverse(s.begin(), s.begin() + m);
            reverse(s.begin(), s.begin() + r);
        }
        l = 0, r = s.size() - 1;
        while (r >= 0 && s[r] == ' ') r--;
        while (l < s.size() - 1 && s[l] == ' ') l++;
        if (l > r) return "";
        return s.substr(l, r - l + 1);
    }
};