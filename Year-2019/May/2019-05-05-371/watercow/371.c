// a ^ b 是二进制无进位加法
// a & b 是需要进1的位

class Solution {
public:
	int getSum(int a, int b) {
		int sum = a ^ b;
		auto carry = ((unsigned int)(a & b) << 1);

		if (carry == 0) return sum;
		else {
			return getSum(sum, carry);
		}
	}
};
