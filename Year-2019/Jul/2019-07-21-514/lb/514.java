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
 * @date ：Created in 2019-10-05 15:40
 * @description：
 */
public class FindRotateSteps {
    //自由之路
    //动态规划
    //当前长度的子字符串需要遍历之前所有的
    //dp[i][j]表示key的前i位，ring的第j位在12点位置上的最少步骤
    //如果key[i]!=ring[j]，dp[i][j]为定值
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];
        //初始化
        for (int i = 0; i < ring.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                dp[j][i] = Integer.MAX_VALUE;
            }
            //寻找第一个字母的最小路径
            if (key.charAt(0) == ring.charAt(i)){
                dp[0][i] = Math.min(i,ring.length()-i);
            }else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < key.length(); i++) {
            //字符的寻找
            //次数的统计
            for (int j = 0; j < ring.length(); j++) {
                //从dp[i-1][0-j]到ring.charAt(j)的最短步数即为dp[i][j]的值
                //dp[i][j]是否可达
                if (key.charAt(i) != ring.charAt(j)){
                    dp[i][j] = Integer.MAX_VALUE;
                }else {
                    //从dp[i-1][0～j]寻找到dp[i][j]的最小步数
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < ring.length(); k++) {
                        //上一节点也必须可达
                        if (dp[i-1][k] != Integer.MAX_VALUE){
                            //计算k到j的最短距离
                            min = Math.min(Math.abs(k-j),ring.length()-Math.abs(k-j));
                            dp[i][j] = Math.min(dp[i][j],dp[i-1][k]+min);
                        }
                    }
                }
            }
        }
        int result = dp[key.length()-1][0];
        for (int i = 0; i < ring.length(); i++) {
            if (result > dp[key.length()-1][i])
                result = dp[key.length()-1][i];
        }
        //加上按按钮的次数
        return result+key.length();
    }
}
