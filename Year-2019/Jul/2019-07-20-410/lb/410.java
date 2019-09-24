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

import java.util.LinkedList;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-20 19:41
 * @description：
 */
public class SplitArray {
    //分割数组的最大值
    //动态规划
    //dp[i][j]表示数组0～i中分j份中最小的最大值
    //dp[i][j] = max(dp[k][j-1],sum(num[k+1],num[i]))，遍历循环k求得最小的dp[i][j]
    public int splitArraydp(int[] nums, int m) {
        int n = nums.length;
        //数组下标可以表示0
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        //求从1开始子数组的分割的最小最大值
        for (int i = 1; i <= n; i++) {
            //分成1～m份
            for (int j = 1; j <= m; j++) {
                //遍历0～i之间的k
                for (int k = 0; k < i; k++) {
                    //使用sub[i] - sub[k]表示后k个数的和
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }


    //使用二分法进行查找
    //范围（max～sum）
    //根据指定的最大值，对数组进行划分成pieces份，如果pieces小于m说明值太小，否则缩小值继续判断
    public int splitArray(int[] nums, int m) {
        //求范围
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (max < num)
                max = num;
        }

        int lo = max;
        int hi = sum;
        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            int pieces = split(nums,mid);
            if (pieces > m){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        //二分的最后，lo等于hi
        return lo;
    }
    //根据最大值分割数组，返回分割数组的份数
    private int split(int[] nums,int largestSum){
        int tempSum = 0;
        int pieces = 1;
        for (int num : nums) {
            if (tempSum + num > largestSum){
                pieces++;
                tempSum = 0;
            }
            tempSum += num;
        }
        return pieces;
    }
}
