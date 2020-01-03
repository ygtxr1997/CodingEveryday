// 8ms, 74%
// 用getline()获取每个单词
class Solution {
public:
    string simplifyPath(string path) {
        stringstream ss(path);
        vector<string> vec;
        string res, tmp;
        while (getline(ss, tmp, '/')) {
            if (tmp == "" || tmp == ".") continue;
            else if (tmp == ".." && !vec.empty()) vec.pop_back();
            else if (tmp != "..") vec.push_back(tmp);
        } 
        for (auto str : vec) res += "/" + str;
        if (res.empty()) return "/";
        return res;
    }
};