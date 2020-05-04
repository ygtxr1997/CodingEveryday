// 贪心思路:每次选择下一步能走最远的节点作为该步跳跃的位置
class Solution {
public:
    int jump(vector<int>& nums) {
        // maxPos:该步能达到的最远距离, end:上一步能达到的范围
        int maxPos = 0, n = nums.size(), end = 0, step = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (maxPos >= i) {
                maxPos = max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    ++step;
                }
            }
        }
        return step;
    }
};