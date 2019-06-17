// 牛顿迭代法
// https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/

class Solution {
public:
	int mySqrt(int x) {
		if (x == 0) return 0;
		double last_res = 0;
		double res = 1;

		while (abs(res - last_res) > 0) {
			last_res = res;
			res = (res + x / res) / 2;
		}
		return int(res);
	}
};
