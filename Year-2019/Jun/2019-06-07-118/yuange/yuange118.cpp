// 0ms，100%
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        for (int i = 1; i <= numRows; ++i) {
            vector<int> cur;
            for (int j = 0; j < i; ++j) {
                if (j == 0 || j == i - 1) cur.push_back(1);
                else cur.push_back(res[i - 2][j - 1] + res[i - 2][j]);
            }
            res.push_back(cur);
        }
        return res;
    }
};