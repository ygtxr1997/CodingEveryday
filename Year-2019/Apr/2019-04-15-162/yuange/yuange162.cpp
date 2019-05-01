// 因为nums[-1] = nums[n] = -∞，由函数的连续性，
// 二分查找两个数，较大数的那一侧一定存在极大值
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        int l = 0, r = n - 1;
        
#define A(x) (((x) == -1 || (x) == n) ? 0 : 1) * nums[((x) + n) % n] + (long)(((x) == -1 || (x) == n) ? 1 : 0) * INT_MIN * 2
        while (l <= r) {
            int m = (l + r) / 2;
            if (A(m) > A(m - 1) && A(m) > A(m + 1)) return m;
            if (A(m) < A(m + 1)) l = m + 1;
            else if (A(m) > A(m + 1)) r = m - 1;
        }
        
        return l;
    }
};
