class Solution {
public:
    int maxProduct(vector<int>& nums) {
        const int INF = 0x3f3f3f3f;
        int ans = -INF;
        int mx = 1, mi = 1; // 一个保存最大，一个保存最小
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] < 0) swap(mx, mi);
            mx = max(mx * nums[i], nums[i]);
            mi = min(mi * nums[i], nums[i]);
            ans = max(ans, mx);
        }
        return ans;
    }
};