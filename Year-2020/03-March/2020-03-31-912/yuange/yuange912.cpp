// 写个快排意思意思
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        quickSort(nums, 0, nums.size() - 1);
        return nums;
    }
    
    void quickSort(vector<int>& vec, int start, int end) {
        if (start < end) {
            int l = start, r = end, pivot = vec[start];
            while (l < r) {
                while (l < r && vec[r] >= pivot) r--;
                vec[l] = vec[r];
                while (l < r && vec[l] <= pivot) l++;
                vec[r] = vec[l];
            }
            vec[l] = pivot;
            quickSort(vec, start, l - 1);
            quickSort(vec, l + 1, end);
        }
    }
};