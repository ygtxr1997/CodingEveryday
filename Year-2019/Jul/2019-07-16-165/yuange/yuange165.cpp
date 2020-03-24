// 0ms，100%
class Solution {
public:
    int compareVersion(string version1, string version2) {
        char c = 0;
        int a = 0, b = 0;
        istringstream iss1(version1);
        istringstream iss2(version2);
        // 必须用+，不能用||，否则会存在第二个b得不到输入
        while (bool(iss1 >> a) + bool(iss2 >> b)) {
            if (a > b) return 1;
            if (a < b) return -1;
            a = b = 0;
            iss1 >> c;
            iss2 >> c;
        }
        return 0;
    }
};