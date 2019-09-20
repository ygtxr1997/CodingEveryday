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
 * @date ：Created in 2019-09-19 16:58
 * @description：
 */
public class RemoveBoxes {
    //移除盒子
    //动态规划 dp[i][j][k] = (1+k) * (k+1) + dp[i+1][j][0]
    //k表示第i位左边有k个与boxes[i]相等,k的初始值为0
    //result = max(res,dp[i+1][m-1][0] + dp[m][j][k+1](boxes[i] == boxes[m]))
    //res只考虑i的左边相同的情况，存在中间与boxes[i]相等的情况
    
    //动态规划为记录中间结果的值，并不是一定需要求的所有中间值
    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        int[][][] dp = new int[length][length][length];
        return  subset(boxes,0,length-1,0,dp);
    }

    public int subset(int[] boxes,int i,int j,int k,int[][][] dp){
        if (i > j)
            return 0;
        if (dp[i][j][k] > 0)
            return dp[i][j][k];
        int res = 0;
        for (;i < j && boxes[i] == boxes[i+1];i++,k++);
        //前k个已经计算了
        res = (1+k) * (k+1) + subset(boxes,i+1,j,0,dp);

        for (int l = i+1; l <= j; l++) {
            if (boxes[i] == boxes[l])
                //中间部分和右边部分的值
                res = Math.max(res,subset(boxes,i+1,l-1,0,dp)+subset(boxes,l,j,k+1,dp));
        }
        dp[i][j][k] = res;
        return  res;
    }
}
