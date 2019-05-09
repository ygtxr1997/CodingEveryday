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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}


// public class Solution {
//     private int lOrR;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null){
//             lOrR = 0;
//             return null;
//         }
        
//         int tmp = 0;
//         if(root == p){
//             tmp = 1;
//         }
//         else if(root == q){
//             tmp = 2;
//         }
        
//         TreeNode tmp1 = lowestCommonAncestor(root.left, p, q);
//         if(tmp1 != null)
//             return tmp1;
//         if(lOrR != tmp){
//             tmp += lOrR;
//         }
//         tmp1 = lowestCommonAncestor(root.right, p, q);
//         if(tmp1 != null)
//             return tmp1;
//         if(lOrR != tmp){
//             tmp += lOrR;
//         }
        
//         if(tmp == 3)
//             return root;
//         else {
//             lOrR = tmp;
//             return null;
//         }
//     }
// }