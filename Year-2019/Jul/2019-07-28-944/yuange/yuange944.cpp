class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        if (A.empty()) return 0;
        int n = A.size(), m = A[0].size();
        int res = 0;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i][j] > A[i + 1][j]) {res++; break;}
            }
        }
        return res;
    }
};