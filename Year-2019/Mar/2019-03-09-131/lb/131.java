import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    List<List<String>> ret = new LinkedList<>();
    List<String> tempRet = new LinkedList<>();
    /**
     * 使用回溯的方法去寻找所有满足条件的字符串
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        getPalindrome(s);
        return ret;
    }

    /**
     * 回溯寻找回文串
     * @param str
     */
    public void getPalindrome(String str){
        //不考虑空字符串
        if (str.length() == 0){
            List<String> result = new ArrayList<>();
            result.addAll(tempRet);
            ret.add(result);
            return;
        }
        //单字符串肯定为回文串，且为跳出循环的条件
        if (str.length() == 1){
            tempRet.add(str);
            List<String> result = new ArrayList<>();
            result.addAll(tempRet);
            ret.add(result);
            tempRet.remove(tempRet.size()-1);
            return;
        }
        int length = str.length();
        String temp;
        for (int i=1;i<length+1;i++){
            temp = str.substring(0,i);
            if (isPalindrome(temp)){
                tempRet.add(temp);
                //回溯
                getPalindrome(str.substring(i));
                //如果直接remove temp则会导致之前的相同的temp也会被去除掉
                tempRet.remove(tempRet.size()-1);
            }
        }
    }
    /**
     * 验证是否为回文串
     * @param string
     * @return
     */
    public boolean isPalindrome(String string){
        char[] str = string.toCharArray();
        int start = 0;
        int end = str.length-1;
        for (;start<end;start++,end--){
            if (str[start] != str[end])
                return false;
        }
        return true;
    }
}
