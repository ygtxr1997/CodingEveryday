class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> nums;
        int i {};
        int j {};
        while(i < m && j < n)
        {
            if(nums1[i] > nums2[j])
                nums.push_back(nums2[j++]);
            else
                nums.push_back(nums1[i++]);
        }
        if(j == n)
            while(i < m)
                nums.push_back(nums1[i++]);
        if(i == nums1.size() - n)
            while(j < n)
                nums.push_back(nums2[j++]);
        i = 0;
        for(auto num : nums)
            nums1[i++] = num;
    }
};