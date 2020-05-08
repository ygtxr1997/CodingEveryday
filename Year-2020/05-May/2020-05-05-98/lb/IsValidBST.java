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
import java.util.LinkedList;
import java.util.List;

/**
 * @program: idea
 * @description: 验证二叉搜索树
 * @author: Lovely Dragon
 * @create: 2020-05-07 11:42
 */
public class IsValidBST {
    //递归遍历
    //中序遍历为升序即为二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (left(root.val,root.left) && right(root.val,root.right)){
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }

    public boolean left(int val,TreeNode left){
        if (left == null)
            return true;
        if (left.val >= val)
            return false;
        return left(val,left.left) && left(val,left.right);
    }

    public boolean right(int val,TreeNode right){
        if (right == null)
            return true;
        if (right.val <= val)
            return false;
        return right(val,right.left) && right(val,right.right);
    }

    //中序遍历
    List<Integer> list = new ArrayList<>();
    public void midSort(TreeNode treeNode){
        if (treeNode == null)
            return ;
        midSort(treeNode.left);
        list.add(treeNode.val);
        midSort(treeNode.right);
    }
}
