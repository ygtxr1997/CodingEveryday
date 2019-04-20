class Solution {
public:
	void wiggleSort(vector<int>& nums) {
		int size = nums.size();
		sort(nums.begin(), nums.end());
		vector<int> tmp = nums;

		int K = size - 1;
		for (int i = 1; i < size; i += 2) {
			nums[i] = tmp[K--];
		}
		for (int i = 0; i < size; i += 2) {
			nums[i] = tmp[K--];
		}
	}
};
