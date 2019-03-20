// 非常神奇的思路，好好体会，还要注意等号的问题
// 把数组从左到右分成几个部分：比mi大的---mi---比ma大的---ma---待定，mi<ma
class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int mi = INT_MAX, ma = INT_MAX;
        for (auto i : nums)
            if (i <= mi) mi = i;
            else if (i <= ma) ma = i;
            else return true;
        return false;
    }
};
