package com.company;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    //二叉树的层序遍历
    //根据层数判断创建新的列表
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new LinkedList<>();
        level(root,0);
        return  result;
    }

    public void level(TreeNode node, int level){
        if (node == null)
            return;
        List<Integer> list;
        if (result.size() <= level ){
            list = new LinkedList<>();
            result.add(list);
        }else
            list = result.get(level);
        list.add(node.val);
        level(node.left,level+1);
        level(node.right,level+1);
    }
}
