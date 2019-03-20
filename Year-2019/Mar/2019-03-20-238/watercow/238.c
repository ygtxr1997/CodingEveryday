// 注意题目要求不能使用除法
// 两次遍历
// 1) left_product[]第一次从左向右：记录当前位置的左侧(不包括当前数)所有数的乘积
// 2) right_product[]第二次从右向左：记录当前位置的右侧(不包括当前数)所有数的乘积
// 3) 对nums[i]将第一步得到的left_product[i]乘上right_product[i]

class Solution {
public:
	vector<int> productExceptSelf(vector<int>& nums) {
		int length = nums.size();
		vector<int> left_product(length, 1);
		vector<int> right_product(length, 1);
		int cur_product = 1;

		// step 1:
		for (int i = 0; i < length; i++) {
			left_product[i] *= cur_product;
			cur_product *= nums[i];
		}

		// step 2:
		cur_product = 1;
		for (int i = length - 1; i >= 0; i--) {
			right_product[i] *= cur_product;
			cur_product *= nums[i];
		}

		// step 3:
		for (int i = 0; i < length; i++) {
			nums[i] = left_product[i] * right_product[i];
		}

		return nums;
	}
};