class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = depthLeft(root.left);
        int right = depthRight(root.right);
        if(left == right){
            return (1 << left) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    
    
    public int depthLeft(TreeNode root){
        int count = 1;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    
    
    public int depthRight(TreeNode root){
        int count = 1;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
    
}