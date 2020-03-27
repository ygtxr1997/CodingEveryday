// L和R不能相互越过
// L的移动会使其左边的X数量减少，右边的X数量增加，XL->LX
// R的移动会使其右边的X数量减少，左边的X数量增加，RX->XR
class Solution {
public:
    bool canTransform(string start, string end) {
        int i = 0, j = 0;
        while (i < start.size() && j < end.size()) {
            while (i < start.size() && start[i] == 'X') i++;
            while (j < start.size() && end[j] == 'X') j++;
            if (start[i] != end[j]) return false;
            if ((start[i] == 'L' && i < j)
               || (start[i] == 'R' && i > j)) return false;
            i++;
            j++;
        }
        return true;
    }
};