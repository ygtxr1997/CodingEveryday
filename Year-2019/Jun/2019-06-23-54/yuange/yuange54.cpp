// 还可以用正负号di、dj代表方向，用0代表已经遍历过的位置
// 0ms，100%
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.empty()) return vector<int>();
        int l = 0, u = 0, r = matrix[0].size() - 1, d = matrix.size() - 1;
        vector<int> ret;
        do {
            for (int j = l; j <= r; j++) ret.push_back(matrix[u][j]);
            u++; if (u > d) return ret;
            for (int i = u; i <= d; i++) ret.push_back(matrix[i][r]);
            r--; if (l > r) return ret;
            for (int j = r; j >= l; j--) ret.push_back(matrix[d][j]);
            d--;
            for (int i = d; i >= u; i--) ret.push_back(matrix[i][l]);
            l++;
        } while (l <= r && u <= d);
        return ret;
    }
};