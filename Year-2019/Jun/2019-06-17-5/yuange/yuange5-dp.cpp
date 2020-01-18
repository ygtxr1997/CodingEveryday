// dp[i][j]:从i到j的串是否回文
// dp[i][j]=(s[i]==s[j])&&(j-i<=2||dp[i+1][j-1])
// 228ms，28%
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