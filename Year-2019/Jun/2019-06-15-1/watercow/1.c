// 之前第一次做是直接遍历查找满足target - nums[i]的数
// 看官方题解用HashMap加速，有点东西

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		if (nums.size() == 0) return {};

		unordered_map<int, int> Hashmap;
		for (int i = 0; i < nums.size(); i++) {
			 
			if (Hashmap.find(target - nums[i]) != Hashmap.end()) {
				return { i, Hashmap.find(target - nums[i])->second };
			}
			Hashmap.insert(make_pair(nums[i], i));
		}
	}
};
