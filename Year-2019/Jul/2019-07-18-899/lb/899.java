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

import java.util.Arrays;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-09 15:36
 * @description：
 */
public class OrderlyQueue {
    //有序队列
    //string的compareTo方法即为字典序比较
    //S经过多次操作之后总会回到S
    //K代表前k个中的一个放在末端
    //K = 1 时无法改变字符串中各个字符的相对位置则只能循环判断
    //K > 1 时则可以生成当前字符串的任意组合，生成当前字符串最小的字典序的字符串
    public String orderlyQueue(String S, int K) {
        String result = S;
        StringBuffer stringBuffer;
        if (K == 1) {
            String str = S;
            do {
                stringBuffer = new StringBuffer();
                //字符串操作
                stringBuffer.append(S.substring(1));
                stringBuffer.append(S.substring(0, 1));
                S = stringBuffer.toString();
                //字典序比较
                if (result.compareTo(S) > 0) {
                    result = S;
                }
            } while (!S.equals(str));
        }else {
            //排序字符串
            char[] sc = S.toCharArray();
            Arrays.sort(sc);
            stringBuffer = new StringBuffer();
            for (char c : sc){
                stringBuffer.append(c);
            }
            result = stringBuffer.toString();
        }

        return result;
    }
}
