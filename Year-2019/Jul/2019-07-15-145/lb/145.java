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
import java.util.List;
import java.util.Stack;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-08-31 17:50
 * @description：
 */
public class PostorderTraversal {
    //二叉树的后续遍历
    //左 - 右 - 中
    //使用迭代的方法
    //当前节点为空的情况 -- 迭代为上一个节点的左节点 -- 弹出上一个节点
    //当前节点不为空的情况 -- 记录当前节点的值 -- 迭代当前节点的右节点并入栈当前节点
    //对节点进行中左右的进栈的操作 -- 找不出跳出循环的条件
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        //保存节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        stack.push(root);
        while (!stack.empty()){
            if (temp == null){
                temp = stack.peek().left;
                stack.pop();
            }else {
                list.add(temp.val);
                stack.push(temp);
                temp = temp.right;
            }
        }
        List<Integer> result = new LinkedList<>();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            result.add(list.removeLast());
        }
        return result;
    }
}
