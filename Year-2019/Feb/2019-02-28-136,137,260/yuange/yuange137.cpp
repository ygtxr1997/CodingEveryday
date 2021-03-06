﻿// 思路是把10进制整数转化成3进制数，并自定义三进制数的异或函数
#define MAX_LENGTH 24 // 小心内存对齐错误
class Solution {
public:
	int singleNumber(vector<int>& nums) {
		int n = nums.size();
		int ret = 0;
		unsigned char a3[MAX_LENGTH];
		unsigned char b3[MAX_LENGTH];
		memset(a3, 0, sizeof(char)*MAX_LENGTH);
		to3base(nums[0], a3);
		for (int i = 1; i < n; ++i)
		{
			memset(b3, 0, sizeof(char)*MAX_LENGTH);
			to3base(nums[i], b3);
			xor3(a3, b3);
		}
		to10base(a3, ret);
		return ret;
	}

	inline void xor3(unsigned char* a, unsigned char* b)
	{
		for (int i = 0; i < MAX_LENGTH; ++i)
			a[i] = (a[i] + b[i]) % 3;
	}

	inline void to3base(unsigned int x, unsigned char* x3)
	{
		int i = 0;
		while (x != 0)
		{
			x3[i++] = x % 3;
			x /= 3;
		}
	}

	inline void to10base(unsigned char* x3, int& x)
	{
		long base = 1;
		for (int i = 0; i < MAX_LENGTH; ++i)
		{
			x += (x3[i] * base);
			base *= 3;
		}
	}
};