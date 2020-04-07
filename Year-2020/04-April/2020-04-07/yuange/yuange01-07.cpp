// 找好对应坐标关系即可
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        if (matrix.empty()) return;
        int N = matrix.size();
        for (int i = 0; i < N / 2; ++i) {
            for (int j = 0; j < (N + 1) / 2; ++j) {
                cout << i << ' ' << j << endl;
                swap4(matrix[i][j], 
                    matrix[j][N - 1 - i],
                    matrix[N - 1 - i][N - 1 - j],
                    matrix[N - 1 - j][i]);
            }
        }
    }

    inline void swap4(int& a1, int& a2, int& a3, int& a4) {
        int tmp = a1;
        a1 = a4; a4 = a3; a3 = a2; a2 = tmp;
    }
};