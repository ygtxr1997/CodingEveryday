// 0ms，100%
class Solution {
public:
    int fib(int N) {
        if (N < 2) return N;
        int r1 = 0, r2 = 1;
        for (int i = 2; i <= N; i += 2) {
            r1 += r2;
            r2 += r1;
        }
        return N % 2 ? r2 : r1;
    }
};