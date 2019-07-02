// 这个题解有点东西
// https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/

// 中心扩散法
class Solution {
public:
	string longestPalindrome(string s) {
		int size = s.size();
		if (size == 0) return "";

		int maxPalindrome = 0;
		string maxPalindromeStr = "";
		string res;

		for (int i = 0; i < size; i++) {
			string palindromeOdd = center_spread(s, size, i, i);
			string palindromeEven = center_spread(s, size, i, i + 1);

			int lenOdd = palindromeOdd.length();
			int lenEven = palindromeEven.length();

			if (lenOdd >= lenEven) {
				res = palindromeOdd;
			}
			else {
				res = palindromeEven;
			}

			if (res.length() > maxPalindrome) {
				maxPalindrome = res.length();
				maxPalindromeStr = res;
			}
		}
		return maxPalindromeStr;
	}

	string center_spread(string s, int size, int left, int right) {
		// left == right时表明，该回文序列是奇数(回文中心是某个字符)
		// left == right - 1表明，该回文序列是偶数(回文中心不是字符)
		int l = left, r = right;

		while (l >= 0 and r < size and s[l] == s[r]) {
			l -= 1;
			r += 1;
		}

		return s.substr(l + 1, r - l - 1); // 第二个参数 之所以是减1 不是2

	}
};
