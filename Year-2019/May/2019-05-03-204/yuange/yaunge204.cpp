// 24ms, 90%，线性素数筛法
class Solution {
public:
    int countPrimes(int n) {
        bool prime[n + 1] = {0};      // false代表是素数
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (!prime[i]) {             // 是素数
                ++ans;
                for (int j = i + i; j < n; j += i) {
                    prime[j] = true;    // 和数全部置1
                }
            }
        }
        return ans;
    }
};
