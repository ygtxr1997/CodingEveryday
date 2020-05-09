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
 * @program: idea
 * @description: 无重复字符的最长子串
 * @author: Lovely Dragon
 * @create: 2020-05-09 08:47
 */
public class LengthOfLongestSubstring {
    //双指针循环找出最长的字串
    public int lengthOfLongestSubstring(String s) {
        int i =0;
        int j =0;
        int len = s.length();
        int max = 0;
        int[] dp = new int[256];//字符判断
        while (j<len){
            dp[s.charAt(j)]++;
            //存在重复字符
            if (dp[s.charAt(j)] == 2){
                while (true){
                    dp[s.charAt(i)]--;
                    if (dp[s.charAt(i)] == 1){
                        i++;
                        break;
                    }
                    i++;
                }
            }
            j++;
            max = (j-i) > max ?j-i:max;
        }
        return max;
    }
}
