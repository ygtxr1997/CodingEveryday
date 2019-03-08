class Solution {

public:
	bool isPalindrome(string s) {
		int length = s.length();
		for (int i = 0, j = length - 1; i < j;) {
			if (!isalpha(s[i]) && !isdigit(s[i])) i++;
			else if (!isalpha(s[j]) && !isdigit(s[j])) j--;
			else if (tolower(s[i]) != tolower(s[j])) return false;
			else {
				i++; j--;
			}
		}
		return true;
	}
};