// 自定义排序函数，比较s1 + s2和s2 + s1的大小，耗时8ms，99%
// 注意要考虑数组全都是0的情况
class Solution {
private:
    static bool compare(const string& s1, const string& s2)
    {
        string ab = s1 + s2;
        string ba = s2 + s1;
        return ab < ba; //升序排列。如改为ab > ba, 则为降序排列
    }
public:
    string largestNumber(vector<int>& nums) {
        bool flag = true;
        vector<string> str;
        for (auto n : nums) {
            stringstream ss;
            ss << n;
            str.push_back(ss.str());
            if (n != 0) flag = false;
        }
        if (flag) return "0";
        sort(str.begin(), str.end(), compare);
        string ret("");
        for (auto s = str.rbegin(); s != str.rend(); ++s)
            ret += *s;
        return ret;
    }
};
