class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& A) {
        int n = A.size(), ans = 0;
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, mx + A[i]);
            mx = max(mx, A[i]) - 1;
        }
        return ans;
    }
};