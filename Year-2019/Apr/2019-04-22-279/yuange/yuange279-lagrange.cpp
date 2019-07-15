// 0ms,100%
// 利用四平方和定理：任何一个整数都可以表示为不超过4个数的平方和
// 推论：当且仅当n=4^a(8b+7)时，n恰好可以表示为4个数的平方和
class Solution {
public:
    int numSquares(int n) {
        while (0 == n % 4) n /= 4;
        if (7 == n % 8) return 4;
        for (int i = 0; i * i < n; ++i) {
            int j = pow(n - i * i, 0.5);
            if (n == i * i + j * j) return !!i + !!j;
        }
        return 3;
    }
};
