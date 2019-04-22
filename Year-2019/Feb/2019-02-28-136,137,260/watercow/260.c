class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int a = 0;
        for (auto i : nums) {
            a ^= i;
        }

        a &= -a; // yushang buma

        int n1 = 0, n2 = 0;

        for (auto i : nums) {
            if (i & a) {
                n1 ^= i;
            }
            else {
                n2 ^= i;
            }
        }

        return vector<int>{n1, n2};
    }
};
