// 见了鬼，直接遍历faster

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if (nums.size() == 1) return 0;
        if (nums.size() == 2) return nums[0] > nums[1] ? 0 : 1;

        int front = 0;
        int mid = 1;
        int end = 2;

        if (nums[front] > nums[mid]) return front;

        for(;end < nums.size();) {
            if(nums[mid] > nums[front] && nums[mid] > nums[end]) 
                return mid;
            else {
                front++;
                mid++;
                end++;
            }
        }
        return --end; 
    }
};
