class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m + n > nums1.length)
            return;
        int i = m - 1, j = n - 1;
        int pos = m + n - 1;
        while(i >=0&& j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[pos--] = nums1[i--];
            }
            else{
                nums1[pos--] = nums2[j--];
            }
        }
        while(i >= 0){
            return;
        }
        while(j >= 0){
            nums1[pos--] = nums2[j--];
        }
        return;
    }
}