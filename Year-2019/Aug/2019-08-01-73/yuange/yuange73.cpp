// 用matrix[][]的首行和首列表示该行或列是否需要全部清0，用额外的bool表示首行首列是否清0，时间O(n*m)，空间O(1)
// 另：空间O(n+m)的方法，用deleted_i[]，deleted_j[]存放已经清零的行或列
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.empty()) return;
        int n = matrix.size(), m = matrix[0].size();
        bool i0 = false, j0 = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) i0 = true;
                    if (j == 0) j0 = true;
                    if (i != 0 && j != 0) matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] != 0) continue;
            for (int j = 1; j < m; ++j) {
                matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < m; ++j) {
            if (matrix[0][j] != 0) continue;
            for (int i = 1; i < n; ++i) {
                matrix[i][j] = 0;
            }
        }
        if (i0) for (int j = 0; j < m; ++j) matrix[0][j] = 0;
        if (j0) for (int i = 0; i < n; ++i) matrix[i][0] = 0;
    }
};