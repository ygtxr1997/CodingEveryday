// 很奇怪,用stable_sort函数可以通过
// 使用sort函数会说堆溢出问题
class Solution {
public:
	static bool cmp(int x, int y) {
		string s1 = to_string(x);
		string s2 = to_string(y);
		return s1 + s2 >= s2 + s1; // string的拼接
	}

	string largestNumber(vector<int>& nums) {
		stable_sort(nums.begin(), nums.end(), cmp);
		string res = "";

		for (int i = 0; i < nums.size(); i++) {
			res += to_string(nums[i]);
		}

		// 如果是[0,0,0]这种情况，就要去掉前面的0
		int i = 0;
		while (i + 1 < res.length() && res[i] == '0') i++;
		
		return res.substr(i);
	}
};
