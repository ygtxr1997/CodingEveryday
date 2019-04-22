// https://blog.csdn.net/qq_41855420/article/details/88368675
// out of TIME !!!
 
class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int size = nums.size();
        map<int, int> leftNumCntMap;
        
        vector<int> res(size, 0);

        for (int i = size - 1; i >= 0; i--) {
            for (auto &pair : leftNumCntMap) {
                if (pair.first >= nums[i]) break;

                res[i] += pair.second;
            }

            leftNumCntMap[nums[i]] += 1;
        }

        return res;
    }
};
