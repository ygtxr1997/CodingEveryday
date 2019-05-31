// 300号题目最长上升子序列的扩展版本
// 首先按照envelopes的长度从短到长排序
// dp[i]表示以envelopes[i]作为最外层的套娃最大深度
// 算法复杂度O(n^2)
class Solution {
public:
	int maxEnvelopes(vector<vector<int>>& envelopes) {
		int n = envelopes.size();
		if (n < 1) return 0;
		int max_ret = 1;
		vector<int> dp(n, 1);

		sort(envelopes.begin(), envelopes.end(), cmp);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] &&
					envelopes[i][1] > envelopes[j][1]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
			max_ret = max(max_ret, dp[i]);
		}
		return max_ret;
	}

	static int cmp(vector<int>& e1, vector<int>& e2) {
		return e1[0] < e2[0];
	}
};
