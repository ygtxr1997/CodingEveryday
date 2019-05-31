// 时间复杂度为O(nlogn)的算法
// 方法如同300题最大上升子序列nlogn解法相似
// 首先对envelopes的第一个元素从小到大排序
// 如果第一个元素相同，则按照第二个元素从大到小排序(注意不是从小到大)
// 排序后相当于将二维上的问题转化成了一维的LIS问题
//（因为长度（第一个元素）已经从小到大排序了），只需看宽度（第二个元素））
// dp[i]表示深度为i+1时最外层信封的宽度

class Solution {
public:
	int maxEnvelopes(vector<vector<int>>& envelopes) {
		int n = envelopes.size();
		int maxL = 0;
		vector<int> dp(n, 0);
		sort(envelopes.begin(), envelopes.end(), cmp);

		for (auto envelope : envelopes) {
			int l = 0, r = maxL;
			while (l < r) {
				int mid = (r + l) / 2;
				if (dp[mid] < envelope[1]) {
					l = mid + 1;
				}
				else r = mid;
			}
			dp[l] = envelope[1];
			if (l == maxL) {
				maxL++;
			}
		}
		return maxL;
	}

	static int cmp(vector<int> &e1, vector<int> &e2) {
		return e1[0] != e2[0] ? e1[0] < e2[0] : e1[1] > e2[1];
	}
};
