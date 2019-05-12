/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder outPut = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode tmp = que.poll();
            if(tmp == null){
                outPut.append("null").append(",");
            }
            else{
                outPut.append(tmp.val).append(",");
                que.offer(tmp.left);
                que.offer(tmp.right);
            }
        }
        // while (outPut.length() > 5){
        //     if(outPut.substring(outPut.length() - 5, outPut.length()).equals("null,"))
        //         outPut.delete(outPut.length() - 5, outPut.length());
        //     else break;
        // }
        if(outPut.length() > 1)
            outPut.deleteCharAt(outPut.length() - 1);

        return outPut.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() < 1)
            return null;

        String[] tmp = data.split(",");
        int i = 0;
        TreeNode head = new TreeNode(Integer.parseInt(tmp[i++]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(head);
        while (!que.isEmpty()){
            TreeNode nodeTmp = que.poll();
            if(i < tmp.length&& !tmp[i++].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(tmp[i - 1]));
                nodeTmp.left = left;
                que.offer(left);
            }
            else {
                nodeTmp.left = null;
            }
            if(i < tmp.length&& !tmp[i++].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(tmp[i - 1]));
                nodeTmp.right = right;
                que.offer(right);
            }
            else {
                nodeTmp.right = null;
            } 
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));