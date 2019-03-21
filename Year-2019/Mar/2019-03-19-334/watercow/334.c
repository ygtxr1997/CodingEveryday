// 秘籍：偷窥流
// 窥测评论中的优秀答案，并拷贝其思路完成解答！
// 贪心算法
// 1) 先找到当前以及之前最小值min
// 2) 找到比min大的max
// 3) 遇到比max大的就返回true
class Solution {
public:
	bool increasingTriplet(vector<int>& nums) {
		int min = INT_MAX, max = INT_MAX;
		for (auto n : nums) {
			if (n < min) min = n;
			else if (n > min and n < max) max = n;
			else if (n > max) return true;
 		}
		return false;
	}
};