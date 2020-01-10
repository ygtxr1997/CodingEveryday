// 常规回溯解法，20ms，81%
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int res = 0;
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                int a = 0;
                trace(matrix, i, j, a);
                res = a > res ? a : res;
            }
        }
        return res * res;
    }
    
    void trace(vector<vector<char>>& M, int i, int j, int& a) {
        if (i + a >= M.size() || j + a >= M[0].size()) return;
        for (int m = i; m <= i + a; ++m) {
            if (M[m][j + a] == '0') return; 
        }
        for (int n = j; n <= j + a; ++n) {
            if (M[i + a][n] == '0') return;
        }
        a++;
        trace(M, i, j, a);
    }
};