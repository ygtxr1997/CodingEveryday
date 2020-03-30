class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        if (A.empty()) return 0;
        int n = A.size(), m = A[0].size();
        int ans = 0;
        vector<bool> cmp(n, true); // 第i行是否需要和下一行比较
        for (int j = 0; j < m; ++j) {
            bool bIncrease = true;
            for (int i = 0; i < n - 1; ++i) {
                if (cmp[i] && A[i][j] > A[i + 1][j]) { 
                    bIncrease = false; 
                    ans++; 
                    break; 
                }
            }
            if (!bIncrease) continue;
            int cnt = 0;
            for (int i = 0; i < n - 1; ++i) {
                if (A[i][j] < A[i + 1][j]) {
                    cmp[i] = false;
                    cnt++;
                }
            }
            if (cnt == n - 1) break;
        }
        return ans;
    }
};