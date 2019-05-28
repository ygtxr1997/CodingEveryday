/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outPut = new LinkedList<>();
        if(root == null)
            return outPut;
        
        Deque<TreeNode> deque = new LinkedList<>(); 
        deque.offerLast(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> tmpList = new LinkedList<>();
            if(flag){
                for(int i = 0; i < size; i++){
                    TreeNode tmpNode = deque.pollFirst();
                    if(tmpNode.left != null)
                        deque.offerLast(tmpNode.left);
                    if(tmpNode.right != null)
                        deque.offerLast(tmpNode.right);
                    tmpList.add(tmpNode.val);
                }
            }
            else {
                for(int i = 0; i < size; i++){
                    TreeNode tmpNode = deque.pollLast();
                    if(tmpNode.right != null)
                        deque.offerFirst(tmpNode.right);
                    if(tmpNode.left != null)
                        deque.offerFirst(tmpNode.left);
                    tmpList.add(tmpNode.val);
                }
            }
            outPut.add(tmpList);
            flag = !flag;
        }
        
        return outPut;
    }
}