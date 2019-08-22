/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root == null)
            return maxWidth;

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> quePos = new LinkedList<>();
        queNode.offer(root);
        quePos.offer(0);
        while (!queNode.isEmpty()){
            int size = queNode.size();
            int begin = 0, end = 0;
            for(int i = 0; i < size; i++){
                TreeNode tmp = queNode.poll();
                int base = quePos.poll();
                if(i == 0) begin = base;
                if(i == size - 1) end = base;
                if(tmp.left != null){
                    queNode.offer(tmp.left);
                    quePos.offer(base * 2);
                }
                if(tmp.right != null){
                    queNode.offer(tmp.right);
                    quePos.offer(base * 2 + 1);
                }
            }
            maxWidth = (end - begin + 1) > maxWidth? (end - begin + 1): maxWidth;
        }
        return maxWidth;
    }
}