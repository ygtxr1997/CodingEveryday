/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */
// 题目封装成了MountainArray()意味着不能用lower_bound
class Solution {
public:
    int findPeak(MountainArray &mountainArr){
        int n = mountainArr.length();
        int left = 0,right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = mountainArr.get(mid);
            if(x > mountainArr.get(mid + 1))
                right = mid - 1;
            else
                left = mid + 1;  
        }
        return left;
    }
    int findInMountainArray(int target, MountainArray &mountainArr) {
        int peak = findPeak(mountainArr);
        int n = mountainArr.length();
        int left = 0,right = peak;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = mountainArr.get(mid);
            if(target == x) return mid;
            if(target < x)
                right = mid - 1;
            else
                left = mid + 1;  
        }
        left = peak, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = mountainArr.get(mid);
            if(target == x) return mid;
            if(target < x)
                left = mid + 1; 
            else
                right = mid - 1;
        }
        return -1;
    }
};