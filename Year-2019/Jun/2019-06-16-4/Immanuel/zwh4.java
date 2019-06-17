public class Solution {
//普普通通的O(M + N)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = (nums1.length + nums2.length) / 2 + 1;
        double outPut1 = 0, outPut2 = 0;
        int pos1 = 0, pos2 = 0;
        while (len > 0&& pos1 < nums1.length&& pos2 < nums2.length){
            if(nums1[pos1] <= nums2[pos2]){
                pos1++;
                len--;
                if(len == 1)
                    outPut1 = nums1[pos1 - 1];
                if(len == 0)
                    outPut2 = nums1[pos1 - 1];
            }
            else{
                pos2++;
                len--;
                if(len == 1)
                    outPut1 = nums2[pos2 - 1];
                if(len == 0)
                    outPut2 = nums2[pos2 - 1];
            }
        }
        while (len > 0&& pos1 < nums1.length){
            len--;
            pos1++;
            if(len == 1)
                outPut1 = nums1[pos1 - 1];
            if(len == 0)
                outPut2 = nums1[pos1 - 1];
        }
        while (len > 0&& pos2 < nums2.length){
            len--;
            pos2++;
            if(len == 1)
                outPut1 = nums2[pos2 - 1];
            if(len == 0)
                outPut2 = nums2[pos2 - 1];
        }
        
        if((nums1.length + nums2.length) % 2 == 1)
            return outPut2;
        else 
            return (outPut1 + outPut2) / 2;
    }
}