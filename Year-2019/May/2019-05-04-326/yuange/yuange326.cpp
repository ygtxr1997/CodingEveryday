// 20ms, 48%
// 或者用int表示的最大3的幂除以n，能整除则说明n为3的幂
class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n == 1) return true;
        else if(n == 0) return false;
        else return isPowerOfThree(n / 3) && n % 3 == 0;
    }
};