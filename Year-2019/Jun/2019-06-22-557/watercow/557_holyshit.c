class Solution {
public:
	string reverseWords(string s) {
		string res = "";
		string tmp = "";

		for (auto &c : s) {
			if (c == ' ' or c == '\0') {
				reverse(tmp.begin(), tmp.end());
				res = res + tmp + c;
				tmp = "";
			}
			else {
				tmp += c;
			}
		}
		return res;
	}
};
