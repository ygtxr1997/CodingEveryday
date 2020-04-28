// 根据异或结果可以找到2个不同的数他们从低到高第一个不同的比特位
class Solution {
public:
    vector<int> singleNumbers(vector<int>& nums) {
        int n = nums.size();
        int all = 0;
        for (int i = 0; i < n; ++i) {
            all ^= nums[i];
        }
        all = (((all - 1) ^ (all)) >> 1) + 1;
        int n1 = 0, n2 = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & all) == 0) n1 ^= nums[i];
            else n2 ^= nums[i];
        }
        return vector<int>({n1, n2});
    }
};