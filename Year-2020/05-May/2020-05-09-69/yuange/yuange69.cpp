class Solution {
public:
    int mySqrt(int x) {
        long lx = x;
        long res = 0;
        while (res * res < lx) res++;
        return res * res > lx ? res - 1 : res;
    }
};