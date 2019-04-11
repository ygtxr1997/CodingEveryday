class Solution {
public:
    int titleToNumber(string s) {
        long long res = 0;
        for (int i = 0; i < s.size(); i++){
            res = res * 26 + s[i] - 'A' + 1;
        }
        return res;
    }
};
