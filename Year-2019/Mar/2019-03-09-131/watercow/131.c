// 一种究极烂的方法
// 没有注释
class Solution {
public:
	vector<vector<string>> partition(string s) {
		vector<vector<string>> result;
		vector<string> one_answer;

		F(s, 0, one_answer, result);

		return result;
	}

	void F(string s, int pos, vector<string> & one_answer, vector<vector<string>> & result) {
		if (pos == s.length()) {
			result.push_back(one_answer);
			return;
		}

		for (int i = pos; i < s.length(); i++) {
			if (isPalindrome(s.substr(pos, i - pos + 1))) {
				one_answer.push_back(s.substr(pos, i - pos + 1));
				F(s, i + 1, one_answer, result);
				one_answer.pop_back();
			}
		}
	}

	bool isPalindrome(string s) {
		int length = s.length();
		for (int i = 0, j = s.length(); i < j;) {
			if (!isalnum(s[i])) i++;
			else if (!isalnum(s[j])) j--;
			else if (tolower(s[i]) != tolower(s[j])) return false;
			else {
				i++, j--;
			}
		}
		return true;
	}
};