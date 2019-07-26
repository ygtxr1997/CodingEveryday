// 0ms, 100%
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int ans = 0;
        while (n) {
            n &= n - 1; // 最后一位的1置为0
            ++ans;
        }
        return ans;
    }
};
