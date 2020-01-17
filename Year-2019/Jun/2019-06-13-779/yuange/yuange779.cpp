// 关键是找到规律，0ms，100%
class Solution {
public:
    int kthGrammar(int N, int K) {
        if (K == 1) return 0;
        int size = 1 << (N - 1);
        if (K > size / 2) return 1 - kthGrammar(N - 1, K - size / 2);
        else return kthGrammar(N - 1, K);
    }
};