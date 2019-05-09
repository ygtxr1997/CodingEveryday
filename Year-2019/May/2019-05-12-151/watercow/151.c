// 没明白要考察什么
// 学了一个新的stringstream

class Solution {
public:
	string reverseWords(string s) {
		stringstream ss;
		string ans = "", temp;
		ss << s;
		while (ss >> temp) {
			ans = " " + temp + ans;
		}

		if (ans != "") {
			ans.erase(ans.begin());
		}

		return ans;
	}
};
