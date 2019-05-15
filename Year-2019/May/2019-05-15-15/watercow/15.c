// 这个题目是问两数之和等于几的进阶版
// 思路是我先固定一个数a， 然后在剩下的部分中
// 使用双指针判断是否有两个和为(0-a)的数

class Solution {
public:
	vector<vector<int>> threeSum(vector<int>& nums) {
		if (nums.size() < 3) return {};

		sort(nums.begin(), nums.end());

		vector<vector<int>> res;
		vector<int> one_res;

		for (int i = 0; i < nums.size() - 3; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // 漏掉这一步超时了
				int first_num = nums[i];
				int target = 0 - nums[i];

				// 双指针找0-first_num的部分
				for (int x = i + 1, y = nums.size() - 1; x < y; ) {
					if (nums[x] + nums[y] == target) {
						one_res.push_back(first_num);
						one_res.push_back(nums[x]);
						one_res.push_back(nums[y]);

						res.push_back(one_res);

						one_res.pop_back();
						one_res.pop_back();
						one_res.pop_back();
					}

					else if (nums[x] + nums[y] < target) {
						while (x < y && nums[x] == nums[x + 1]) x++;
						x++;
					}
					else {
						while (x < y && nums[y] == nums[y - 1]) y--;
						y--;
					}
				}
			} 
		}

		return res;
	}
};
