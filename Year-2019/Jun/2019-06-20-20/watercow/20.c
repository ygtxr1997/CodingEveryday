class Solution {
public:
	bool isValid(string s) {
		stack<char> S;
		for (auto c : s) {
			if (S.empty()) {
				S.push(c);
			}
			else if (c == ']' or c == ')' or c == '}') {
				char currC = S.top();
				if (c == ']' and currC == '[') {
					S.pop();
					continue;
				}
				if (c == ')' and currC == '(') {
					S.pop();
					continue;
				}
				if (c == '}' and currC == '{') {
					S.pop();
					continue;
				}
				else {
					S.push(c);
				}
			}
			else {
				S.push(c);
			}
		}
		return S.empty();
	}
};
