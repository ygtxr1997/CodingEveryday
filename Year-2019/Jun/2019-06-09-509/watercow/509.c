// 最简单的动态规划
// dp[i]表示fib(i)
// dp[i] = dp[i-1] + dp[i-2]

class Solution {
public:
	int fib(int N) {
		if (N == 0) return 0;

		vector<int> dp(N + 1, 0);
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}
};
