// 学到了一个新容器deque双端队列
// 双端队列中的元素可以从两端弹出
class Solution {
public:
	vector<int> maxSlidingWindow(vector<int>& nums, int k) {
		deque<int> windows;
		vector<int> result;

		for (int i = 0; i < nums.size(); i++) {
			if (i >= k && windows.front() <= i - k) {
				windows.pop_front();
			}
			while (!windows.empty() && nums[windows.back()] <= nums[i]) {
				windows.pop_back();
			}
			windows.push_back(i);
			if (i >= k - 1) {
				result.push_back(nums[windows.front()]);
			}
		}

		return result;
	}
};