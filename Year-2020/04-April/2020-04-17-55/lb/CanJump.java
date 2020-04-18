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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ：lovelydragon
 * @date ：Created in 2020-04-17 14:56
 * @description：
 */
public class CanJump {
    //跳跃游戏
    public boolean canJump(int[] nums) {
        //记录达到指定位的距离
        int n = 1;
        for (int i = nums.length-2; i >=0 ; i--) {
            //可达，截断
            if (nums[i] >= n){
                n = 1;
            //不可达，位数加1
            }else {
                n++;
            }
            //最后一位时，n为1可达
            if (i==0&&n>1)
                return false;
        }
        return true;
    }
}
