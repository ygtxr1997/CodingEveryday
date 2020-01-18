// manacher
// 8ms，98%
class Solution {
public:
    string longestPalindrome(string s) {
        string S;
        S.push_back('$');
        for (auto c : s) {
            S.push_back('#');
            S.push_back(c);
        }
        S.push_back('#');
        vector<int> P(S.size(), 1);
        int mx = 0, id = 0, ll = 0, dd = 0;
        for (int i = 1; i < S.size(); ++i) {
            if (mx > i) P[i] = min(P[2 * id - i], mx - i);
            else P[i] = 1;
            while (S[i + P[i]] == S[i - P[i]]) P[i]++;
            if (P[i] + i > mx) {
                mx = P[i] + i;
                id = i;
            }
            if (P[i] > ll) {
                ll = P[i];
                dd = id;
            }
        }
        string ret;
        for (int k = dd - ll + 1; k < dd + ll - 1; ++k)
            if (S[k] != '#') ret.push_back(S[k]);
        return ret;
    }
};