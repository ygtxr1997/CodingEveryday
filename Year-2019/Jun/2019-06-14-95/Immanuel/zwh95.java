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
    private TreeNode clone(TreeNode root, int val){
        if(root == null)
            return null;
        TreeNode copy = new TreeNode(root.val + val);
        copy.left = clone(root.left, val);
        copy.right = clone(root.right, val);
        return copy;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for(int i = 1; i <= n; i++){
            dp[i] = new ArrayList<>();
            for(int j = 0; j < i; j++){
                for(TreeNode tmpL: dp[j]){
                    for(TreeNode tmpR: dp[i - j - 1]){
                        TreeNode root = new TreeNode(j + 1);
                        root.left = tmpL;
                        root.right = clone(tmpR, j + 1);
                        dp[i].add(root);
                    }
                }
            }
        }

        return dp[n];
    }
}