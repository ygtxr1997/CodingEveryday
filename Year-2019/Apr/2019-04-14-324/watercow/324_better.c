//https://blog.csdn.net/qq508618087/article/details/51337187

//https://blog.csdn.net/qq_20480611/article/details/52079689

//https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/ono1-after-median-virtual-indexing


class Solution {
public:
	void wiggleSort(vector<int>& nums) {
		int size = nums.size();

		// find a median
		auto midptr = nums.begin() + size / 2;
		nth_element(nums.begin(), midptr, nums.end());
		int mid = *midptr;

		// index-rewiring
		#define A(i) nums[(1+2*(i)) % (size|1)]

		// 3-way-partition-to-wiggly
		int i = 0, j = 0, K = size - 1;
		while (j <= K) {
			if (A(j) > mid) swap(A(i++), A(j++));
			else if (A(j) < mid) swap(A(j), A(K--));
			else j++;
		}
	}
};
