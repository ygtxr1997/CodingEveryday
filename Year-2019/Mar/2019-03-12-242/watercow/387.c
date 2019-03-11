class Solution {
public:
	int firstUniqChar(string s) {
		vector<int> count(26, 0);

		for (auto i : s) ++count[i - 'a'];

		for (int i = 0; i < s.size(); i++) {
			if (count[s[i] - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
};