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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-10 20:23
 * @description：
 */
public class Permute {
    //全排序
    //回溯算法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : nums){
            list.add(i);
        }
        getResult(result,list,new LinkedList<>(),nums.length);
        return result;
    }
    public void getResult(List<List<Integer>> lists,LinkedList<Integer> list,LinkedList<Integer> temp,int length){

        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
            if (temp.size() == length){
                lists.add(new LinkedList<>(temp));
                temp.removeLast();
                return;
            }
            list.remove(i);
            getResult(lists,list,temp,length);
            list.add(i,temp.removeLast());
        }
    }
}
