class Solution {
public:
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() == 0) {
			return 0;
		}
		int res = 1;
		if (nums.size() == 1) {
			return res;
		}

		int i = 0, j = 1;
		while (j < nums.size()) {
			if (nums[i] != nums[j]) {
				nums[++i] = nums[j];
				res++;
			}
			else {
				j++;
			}
		}
		
		return res;
	}
};
