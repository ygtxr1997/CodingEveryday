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
    private int max = Integer.MIN_VALUE;
    /**
     *
     * @param root
     * @return 代表该结点的单边最大值，而双边最大值已经存在max中了
     */
    private int getMax (TreeNode root){
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = getMax(root.left);
            max = Math.max(max, left);
        }
        if(root.right != null){
            right = getMax(root.right);
            max = Math.max(max, right);
        }
        max = Math.max(max, root.val+ left + right);//存下双边最大值

        int outPut = 0;
        outPut = Math.max(root.val + left, root.val + right);
        outPut = Math.max(outPut, root.val);
        return outPut;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int outPut = getMax(root);
        max = Math.max(max, outPut);
        return max;
    }
}