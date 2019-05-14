// 回溯
// 要添加对0的判断，如：002是错的，只能是2

class Solution {
public:
	vector<string> restoreIpAddresses(string s) {
		if (s.size() > 12) return {};

		vector<string> res;

		dfs(s, res, {}, 0);

		return res;
	}

private:
	void dfs(const string& s, vector<string>& res, vector<string> path, int start) {
		if (start > s.size() || path.size() > 4) return;

		if (start == s.size() && path.size() == 4) {
			res.push_back(path[0] + '.' + path[1] + '.' + path[2] + '.' + path[3]);
			return;
		}

		for (int i = 1; i < 4; i++) {
			string sub = s.substr(start, i);

            // 不符合的情况，跳过
			if (sub.size() == 0 || (sub.size() > 1 && sub[0] == '0') || stoi(sub) > 255)
				continue;

			path.push_back(sub);

			// i最大为3，即最大的ip位数不可能超过3位
			dfs(s, res, path, start + i);

			path.pop_back();
		}
	}
};
