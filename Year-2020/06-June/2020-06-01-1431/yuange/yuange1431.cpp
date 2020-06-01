class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int n = candies.size();
        vector<bool> ret(n, 0);
        int mx = -1;
        for (int i = 0; i < n; i++) {
            mx = max(mx, candies[i]);
        }
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= mx) ret[i] = 1;
        }
        return ret;
    }
};