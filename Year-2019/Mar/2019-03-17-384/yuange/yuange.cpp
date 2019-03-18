class Solution {
private:
	vector<int> orign;
public:
	Solution(vector<int> nums) {
		orign = nums;
	}

	vector<int> reset() {
		return orign;
	}

	// 1.Fisher-Yates Shuffle算法，时间O(n)，空间O(n)
	vector<int> shuffle() {
		vector<int> ret = orign;
		srand(time(0));
		int n = ret.size();
		for (int i = 0; i < n; ++i)
			swap(ret[i], ret[i + (rand() % (n - i))]);
		return ret;
	}
};

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(nums);
* vector<int> param_1 = obj.reset();
* vector<int> param_2 = obj.shuffle();
*/