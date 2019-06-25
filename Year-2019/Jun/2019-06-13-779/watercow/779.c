// 递归问题
// 首先当前行的内容
// 前一半等于上一行的内容
// 后一半等于上一行内容的逆

// 递归为若k <= 上一行长度
// 则返回KthGrammar(N-1, K)
// 若k > 上一行长度
// 则返回1 - KthGrammar(N-1, K-上一行长度)
class Solution {
public:
	int kthGrammar(int N, int K) {
		if (N == 1) return 0;
		if (N == 2) return K == 1 ? 0 : 1;

		int lastLen = (1 << (N - 1)) / 2;

		if (K <= lastLen) {
			return kthGrammar(N - 1, K);
		}
		else {
			return 1 - kthGrammar(N - 1, K - lastLen);
		}
	}
};
