// C++没啥好办法，用位图也会时间爆炸
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        if(nums.size() == 0){
            return false;
        }
        sort(nums.begin(),nums.end());
        
        for(int i = 0; i < nums.size()-1; ++i){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        
        return false;
    }
};
