//                          X层蛋碎，往下找  X层蛋未碎，往上找
// dp(K, N) = 1 + min(max(dp(K - 1, X - 1), dp(K, N - X)))
class Solution {
    int memo[10010][103];
    int dp(int K, int N) {
        if (memo[N][K] == -1) {
            int ans;
            if (N == 0) ans = 0;
            else if (K == 1) ans = N;
            else {
                int lo = 1, hi = N;
                // 二分查找递增函数和递减函数的交点
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);
                    if (t1 < t2) lo = x;
                    else if (t1 > t2) hi = x;
                    else lo = hi = x;
                }
                // 选择交点附近的值(离散函数)
                ans = 1 + min(max(dp(K-1, lo-1), dp(K, N-lo)),
                                   max(dp(K-1, hi-1), dp(K, N-hi)));
            }
            memo[N][K] = ans;
        }
        return memo[N][K];
    }
public:
    int superEggDrop(int K, int N) {
        memset(memo, -1, sizeof(memo));
        return dp(K, N);
    }
};