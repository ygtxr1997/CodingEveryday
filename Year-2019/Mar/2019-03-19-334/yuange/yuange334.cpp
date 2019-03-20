// 非常神奇的思路，好好体会
// 把数组从左到右分成几个部分：比mi大的---mi---大于mi且小于ma的---ma---待定
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
