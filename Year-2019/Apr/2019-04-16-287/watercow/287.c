// http://www.cnblogs.com/jimmycheng/p/7519870.html

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int lenth = nums.size();

        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
};
