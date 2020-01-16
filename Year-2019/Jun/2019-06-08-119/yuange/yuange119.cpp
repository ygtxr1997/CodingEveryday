// 4ms，71%
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> res(rowIndex + 1);
        for (int i = 0; i <= rowIndex; ++i) {
            // 从后向前更新
            for (int j = i; j >= 0; --j) {
                if (j == 0 || j == i) res[j] = 1;
                else res[j] += res[j - 1];
            }
        }
        return res;
    }
};