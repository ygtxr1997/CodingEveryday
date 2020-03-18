// G(i) = i ^ (i/2)，4ms，82%
class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> ret;
        for (int i = 0; i < 1 << n; ++i) ret.push_back(i ^ (i / 2));
        return ret;
    }
};