/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty()|| root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }

        return -1;
    }
}