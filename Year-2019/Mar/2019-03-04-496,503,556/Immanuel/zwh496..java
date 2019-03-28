class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] outPut = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int tmp = -1;
            int j = nums2.length - 1;
            while(nums2[j] != nums1[i]){
                if(nums2[j] > nums1[i]){
                    tmp = nums2[j];
                }
                j--;
            }
            outPut[i] = tmp;
        }
        return outPut;
    }
}