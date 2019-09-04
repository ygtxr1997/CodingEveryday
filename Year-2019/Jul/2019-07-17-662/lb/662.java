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
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-03 19:04
 * @description：
 */
public class WidthOfBinaryTree {
    //层次遍历
    //简化计算
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int max = 1;

        boolean loop = true;
        while (loop){
            loop =false;
            //左边
            while (list.size()>0){
                if (list.getFirst() != null)
                    break;
                list.removeFirst();
            }
            //右边
            while (list.size()>0){
                if (list.getLast() != null)
                    break;
                list.removeLast();
            }
            max = Math.max(max,list.size());
            int length = list.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = list.getFirst();
                if (node == null){
                    list.add(null);
                    list.add(null);
                }else {
                    loop = true;
                    list.add(node.left);
                    list.add(node.right);
                }
                list.removeFirst();
            }
        }
        return max;
    }
    //二叉树的最大宽度
    //要与二叉树每层最多节点2^(n-1)挂钩
    //当前层与上一层有一定的关联，最左为null时，永久减2
    //层次遍历，不需要null节点进栈
    public int widthOfBinaryTree_wrongWay(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        int max = 1;
        list.add(root);
        //迭代一层永久减少数
        long sub = 0;
        //层数
        int lay = 0;
        while (list.size() > 0){
            //当前层的sub会继承上一层sub的2倍
            sub *= 2;
            lay++;
            max = Math.max(max,(int)((long)Math.pow(2,lay-1)-sub));
            //左边永久删除
            for (TreeNode node : list){
                if (node.left == null){
                    sub++;
                    if (node.right == null){
                        sub++;
                    }else
                        break;
                }else
                    break;
            }
            //右边永久删除
            for (int i = list.size()-1; i >=0 ; i--) {
                TreeNode node = list.get(i);
                if (node.right == null){
                    sub++;
                    if (node.left == null)
                        sub++;
                    else
                        break;
                }else
                    break;
            }
            //下一层的节点
            int length = list.size();
            for (int i = 0; i < length;i++) {
                if (list.getFirst().left != null){
                    list.add(list.getFirst().left);
                }
                if (list.getFirst().right != null){
                    list.add(list.getFirst().right);
                }
                list.removeFirst();
            }
        }
        return max;
    }
    //左右两个端点不为空，中间的空节点算为一个节点
    //宽度是针对每一层的
    //层次遍历
    //存在无法入栈的null节点，例如[1,1,1,1,null,null,1,1,null,null,1]
    public int widthOfBinaryTree_timeOut(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;
        stack.push(root);
        boolean loop = true;
        //空指针也需要进栈，但最前和最后的空指针不计算在max内
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        while (loop){
            loop = false;
            //把入栈的结果放入双向链表进行筛选
            while (!stack.isEmpty()){
                //最前的为右边，最后的为左边
                linkedList.add(stack.pop());
            }
            //清除最前的null
            int left = 0;
            for (TreeNode node:linkedList) {
                if (node != null)
                    break;
                left++;
            }
            //清除最后的null
            int right = 0;
            for (int i = linkedList.size()-1; i >= 0 ; i--) {
                if (linkedList.get(i) != null)
                    break;
                right++;
            }
            max = Math.max(linkedList.size() - left - right,max);
            //重新入栈,下一层入栈
            //入栈的顺序需要统一
            TreeNode node;
            while (linkedList.size() > 0 ){
                node = linkedList.getLast();
                if (node != null){
                    loop = true;
                    stack.push(node.left);
                    stack.push(node.right);
                }else{
                    stack.push(null);
                    stack.push(null);
                }
                linkedList.removeLast();
            }
            //保证每次循环list清空
        }
        return max;
    }
}

