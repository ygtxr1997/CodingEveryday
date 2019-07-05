// 马拉车算法O(n)
// 参考
// https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
// https://www.bilibili.com/video/av44612474?from=search&seid=18013563000759438219

class Solution {
public:
	string longestPalindrome(string s) {
		int sLen = s.length();
		if (sLen == 0) return "";
		string new_s = "";

		// 预处理
		new_s += "$#";
		for (int i = 0; i < sLen; i++) {
			new_s = new_s + s[i] + "#";
		}
		int newLen = new_s.length();

		// 马拉车
		vector<int> P(newLen, 1);
		int longestStr = 1;
		string resold = s.substr(0, 1);
		string res = "";
		int id = 0, mx = 0;
		for (int i = 0; i < newLen; i++) {
			P[i] = mx > i ? min(P[2 * id - i], mx - i) : 1;

			while (i - P[i] >= 0 and i + P[i] < newLen and new_s[i - P[i]] == new_s[i + P[i]]) {
				P[i]++;
			}
			// 修改id和mx
			if (i + P[i] > mx) {
				mx = i + P[i];
				id = i;
			}

			if (P[i] - 1 > longestStr) {
				longestStr = P[i] - 1;
				resold = new_s.substr(i - P[i] + 1, i + P[i] - (i - P[i] + 1));
			}

			// 剔除"#"生成res
			res = "";
			for (int j = 0; j < resold.length(); j++) {
				if (resold[j] != '#' and resold[j] != '$') {
					res += resold[j];
				}
			}
		}
		return res;
	}
};
