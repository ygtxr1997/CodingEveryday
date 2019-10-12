/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-10-12 17:12
 * @description：
 */
public class SearchRange {
    //在排序数组中查找元素的第一个和最后一个位置
    //二分
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1,-1};
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        //保证mid为最后的中间值
        while (low <= high){
            mid = low + (high-low)/2;
            if (nums[mid] == target)
                break;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (nums[mid] != target)
            return new int[]{-1,-1};
        low = high = mid;
        for (int i = mid-1; i >= 0 ; i--) {
            if (nums[i] == target)
                low = i;
            else
                break;
        }
        for (int i = mid+1;i<nums.length;i++){
            if (nums[i] == target)
                high = i;
            else
                break;
        }
        return new int[]{low,high};
    }
}
