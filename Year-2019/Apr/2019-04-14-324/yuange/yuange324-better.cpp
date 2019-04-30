// 这个思路和yuange324.cpp的思路相同，只不过用了映射序号，在3路partition的时候更容易理解
// 其实关键就是弄懂3路partition为什么在这里有效，68ms,99%
class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();
        nth_element(nums.begin(), nums.begin() + n / 2, nums.end());
        int p = nums[n / 2];
        
        // remap index，神仙操作
        // n | 1 : 不大于的n的最小奇数
        // 其实就是把数组序号重新按照这个顺序映射
        //  0   1   2   3   4   5   6   7
        // -------------------------------
        //  4       5       6       7
        //      0       1       2       3
#define A(x) nums[(1 + 2 * (x)) % ( n | 1)]
        
        // 3 way partition
        int j = 0, k = n - 1, i = 0;
        while (i <= k) { // 其实只要保证每个元素都被遍历过即可，所以也能用for n次代替
            if (A(i) > p) swap(A(i++), A(j++));
            else if (A(i) < p) swap(A(i), A(k--));
            else i++;
        }
        
    }
};
