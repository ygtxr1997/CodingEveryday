// 还是用异或，设单独出现的数字为a和b，与a异或某位为1但与b该位异或为0的数分成两组
class Solution {
public:
	vector<int> singleNumber(vector<int>& nums) {
		int x = 0, a = 0, b = 0;
		for (auto item : nums)
			x ^= item;
		x &= -x; // 使用这种方式可以更快地找到异或bit位为1的位置
		for (auto item : nums)
		{
			if (item & x)
				a ^= item;
			else
				b ^= item;
		}
		return vector<int>{a, b};
	}
};