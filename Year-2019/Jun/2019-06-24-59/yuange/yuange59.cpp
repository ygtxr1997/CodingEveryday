// 0ms，100%
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ret(n, vector<int>(n, 0));
        int l = 0, r = n - 1, u = 0, d = n - 1;
        int k = 1, m = n * n;
        while (k <= m) {
            for (int i = l; i <= r; ++i) ret[u][i] = k++;
            u++; if (u > d) return ret;
            for (int i = u; i <= d; ++i) ret[i][r] = k++;
            r--; if (l > r) return ret;
            for (int i = r; i >= l; --i) ret[d][i] = k++;
            d--;
            for (int i = d; i >= u; --i) ret[i][l] = k++;
            l++;
        }
        return ret;
    }
};