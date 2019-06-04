public class Solution {    
    public int mySqrt(int x) {
        long outPut = x;
        while (outPut * outPut > x){
            outPut = (outPut + x / outPut) / 2;
        }
        return (int)outPut;
    }
    
    // public int mySqrt(int x) {
    //     if (x == 0)
    //         return 0;
    //     int left = 1, right = Integer.MAX_VALUE;
    //     while (true) {
    //         int mid = left + (right - left)/2;
    //         if (mid > x/mid) {
    //             right = mid - 1;
    //         } else {
    //             if (mid + 1 > x/(mid + 1))
    //                 return mid;
    //             left = mid + 1;
    //         }
    //     }
    // }
}