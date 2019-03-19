// 使用心灵控制：10费
// 效果：窃取GG智慧
class Solution {
public:
	vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
		unordered_map<int, int> map1, map2;
		for (auto i : nums1) {
			auto ipair = map1.find(i);
			if (ipair != map1.end()) ipair->second++;
			else map1.insert(pair<int, int>(i, 1));
		}
		for (auto i : nums2) {
			auto ipair = map2.find(i);
			if (ipair != map2.end()) ipair->second++;
			else map2.insert(pair<int, int>(i, 1));
		}
		vector<int> result;
		for (auto ipair1 : map1) {
			auto ipair2 = map2.find(ipair1.first);
			if (ipair2 != map2.end()) {
				int n = min(ipair1.second, ipair2->second);
				for (int i = 0; i < n; i++) {
					result.push_back(ipair1.first);
				}
			}
		}
		return result;
	}
};
