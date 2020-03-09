// 对比删除重复项；因为要原地修改，不得申请额外空间
class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        int n = arr.size();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) {
                arr.insert(arr.begin() + i, 0);
                i++;
            }
        }
        arr.resize(n);
    }
};