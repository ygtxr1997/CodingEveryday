class Solution {
public:
    bool isHappy(int n) {
        set<int> hash;
        int num = n, flag = 0;
        while (hash.count(num) == 0) {
            hash.insert(num);
            if (num == 1) { flag = 1; break; } // 可以变为1
            int next = 0;
            while (num > 0) {
                next += (num % 10) * (num % 10);
                num /= 10;
            }
            num = next;
        }
        return flag;
    }
};