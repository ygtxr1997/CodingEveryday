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
 * @date ：Created in 2019-03-06 21:45
 * @description：使用递归的方式，变换状态方程的形式，可以说是用dp或者遍历的方式去求解
 */
public class CanPartitionBetter {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        if(sum%2!=0) return false;
        //遍历所有可能的情况
        return helper(nums, nums.length - 1, sum/2);
    }
    private boolean helper(int[] nums, int i, int sum) {
        //跳出递归的判定
        if(sum == 0) return true;
        else if(i < 0 || sum < 0 || sum < nums[i]) {
            return false;
        }
        else {
            //装或者不装
            return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
        }
    }
}
