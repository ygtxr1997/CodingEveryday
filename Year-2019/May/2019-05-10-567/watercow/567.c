// 滑动窗口 + hashmap
// 1.首先将s1中的每个字符存入hashmap中
// 2.滑动窗口在s2上移动
//   <front指针>：出现的元素就在hashmap中count - 1
//   <tail指针>：出现的元素在hashmap中count + 1

class Solution {
public:
	bool checkInclusion(string s1, string s2) {
		if (s1.size() > s2.size()) return false;

		vector<int> res(128, 0);
		unordered_map<int, int> hashmap;


		// 第1步
		for (auto ch : s1) {
			res[ch] += 1;
			if (hashmap.find(ch) == hashmap.end()) {
				hashmap.insert(make_pair(ch, 1));
			}
		}

		// 第2步
		int front = 0, tail = 0;
		while (front < s2.size()) {
			
			if (hashmap.find(s2[front]) != hashmap.end() && res[s2[front]]) {
				res[s2[front]] --;
				if (front - tail == s1.size() - 1) return true;
				front++;
				continue;
			}

			else if (hashmap.find(s2[tail]) != hashmap.end()) {
				res[s2[tail]]++;
				tail++;
				continue;
			}

			front++;
			tail++;
		}

		return false;
	}
};
