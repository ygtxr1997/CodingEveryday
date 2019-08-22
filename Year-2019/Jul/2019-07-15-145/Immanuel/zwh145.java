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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> travel = new LinkedList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pollLast();
            if(tmp != null){
                travel.add(0,tmp.val);
                stack.offerLast(tmp.left);
                stack.offerLast(tmp.right);
            }
        }
        return travel;
    }
    
    //紧凑写法
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> travel = new LinkedList<>();

//         Deque<TreeNode> stack = new LinkedList<TreeNode>();
//         TreeNode visited = null;
//         while (!stack.isEmpty() || root != null){
//             if (root != null){
//                 stack.offerLast(root);
//                 root = root.left;
//             }
//             else{    
//                 TreeNode tmp = stack.peekLast();
//                 if(tmp.right == null || tmp.right == visited){
//                     travel.add(stack.pollLast().val);
//                     visited = tmp;
//                 }
//                 else {
//                     root = tmp.right;
//                 }
//             }
//         }

//         return travel;
//     }
    //易理解
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> travel = new LinkedList<>();
//         if(root == null)
//             return travel;

//         Deque<TreeNode> stack = new LinkedList<TreeNode>();
//         TreeNode tmp = null;
//         while (root != null){
//             stack.offerLast(root);
//             root = root.left;
//         }
//         while (!stack.isEmpty()){
//             root = stack.peekLast();
//             if(root.right == null || root.right == tmp){
//                 travel.add(stack.pollLast().val);
//                 tmp = root;
//             }
//             else {
//                 root = root.right;
//                 while (root != null){
//                     stack.offerLast(root);
//                     root = root.left;
//                 }
//             }
//         }

//         return travel;
//     }
}