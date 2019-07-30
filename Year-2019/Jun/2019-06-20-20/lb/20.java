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

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-07-30 12:03
 * @description：
 */
public class IsValid {
    //使用栈
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] strc = s.toCharArray();
        //配对
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('{','}');
        hashMap.put('[',']');
        hashMap.put('(',')');
        //左括弧
        String left = "([{";
        for (int i = 0; i < strc.length; i++) {
            if (left.indexOf(strc[i]) != -1){
                stack.push(strc[i]);
            }else {
                if (stack.size() == 0 || !hashMap.get(stack.peek()).equals(strc[i]))
                    return false;
                stack.pop();
            }
        }
        if (stack.size() != 0)
            return false;
        return true;
    }
}
