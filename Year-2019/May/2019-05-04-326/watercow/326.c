// 活见鬼 还有这种玩法

class Solution {
public:
	bool isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0; // 1162261467是3的19次幂，是整数范围内最大的3的幂次
	}
};
