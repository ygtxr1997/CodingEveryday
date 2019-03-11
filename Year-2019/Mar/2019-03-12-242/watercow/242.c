class Solution {
public:
	bool isAnagram(string s, string t) {
		vector<int> count(26, 0);

		for (auto i : s) ++count[i - 'a'];
		for (auto i : t) --count[i - 'a'];

		for (auto i : count) {
			if (i != 0) return false;
		}

		return true;
	}
};
