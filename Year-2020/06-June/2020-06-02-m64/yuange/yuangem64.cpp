class Solution {
public:
    int sumNums(int n) {
        return (int)(pow(n, 2) + n) >> 1;
    }
};