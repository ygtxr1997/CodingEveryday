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

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-10-12 15:37
 * @description：
 */
public class MinDeletionSize {
    //删列造序
    //要使每一个字符串的每一列的顺序都是一定的
    public int minDeletionSize(String[] A) {
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) - A[j-1].charAt(i) < 0){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    //删列造序2
    //整个字符串按照字典序进行排序，只要前几列的字母偏大，那么这个字符串就偏大
    //对相等的字符进行判断
    public int minDeletionSize2(String[] A) {
        int result = 0;
        int length = A.length;
        //存放已经按字典序排序的且不会被删除的字符串位置
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length-1; j++) {
                //对于已经小于下一行的字符串不需要重复考虑
                if (set.contains(j))
                    continue;
                if (A[j].charAt(i) < A[j+1].charAt(i)){
                    tempList.add(j);
                }else if (A[j].charAt(i) > A[j+1].charAt(i)){
                    result++;
                    //该行删除，重新计数
                    tempList.clear();
                    break;
                }
            }
            set.addAll(tempList);
            tempList.clear();
        }
        return result;
    }
}
