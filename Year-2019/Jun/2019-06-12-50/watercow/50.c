class Solution {
public:
	double FuckPow(double x, long long N) {
		if (N == 0) {
			return 1.0;
		}
		double half = FuckPow(x, N / 2);
		if (N % 2 == 0) {
			return half * half;
		}
		else {
			return x * half * half;
		}
	}

	double myPow(double x, int n) {
		long long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		return FuckPow(x, N);
	}
};
