// 0ms，100%
class Solution {
public:
    int climbStairs(int n) {
        if (n < 2) return 1;
        int r1 = 1, r2 = 1;
        for (int i = 2; i <= n; i += 2) {
            r1 += r2;
            r2 += r1;
        }
        return n % 2 ? r2 : r1;
    }
};