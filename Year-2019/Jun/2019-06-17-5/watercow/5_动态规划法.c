// 这个题解有点东西
// https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/

// 动态规划法
// dp[l][r]表示s.substr(l, r-l+1)的子串是否为回文串,true/false
// dp[l][r] = (s[l] == s[r]) and (r-l <= 2 or dp[l+1][r-1])
class Solution {
public:
	string longestPalindrome(string s) {
		int size = s.length();
		if (size <= 1) return s;

		vector<vector<bool>> dp(size, vector<bool>(size, false));

		int longestLen = 1;
		string res = s.substr(0, 1);

		for (int r = 1; r < size; r++) {
			for (int l = 0; l < r; l++) {
				if (s[l] == s[r] and (r - l <= 2 or dp[l + 1][r - 1])) {
					dp[l][r] = true;
					int curLen = r - l + 1;
					if (curLen > longestLen) {
						longestLen = curLen;
						res = s.substr(l, r - l + 1);
					}
				}
			}
		}
		return res;
	}
};
