public class CountNodes {
    boolean tag = true;
    int count = 0;//最后一层的节点数

    /**
     * 根据层数和最后一层的节点数来计算这颗树的节点数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int h=0;//高度
        TreeNode temp = root;
        while (temp != null){
            h++;
            temp = temp.left;
        }
        //求末尾层的叶子点
        countLeaf(1,h,root);
        //count计算所求叶子节点的数量
        //可以计算左右叶子节点，所以需要除于2，这样可以直接根据层数直接判断
        return count+ (int)Math.pow(2,h-1)-1;
    }
    public void countLeaf(int cur,int h,TreeNode node){
        if (tag){
            if (cur == h-1 && node == null){
                tag = false;
                return;
            }
            if (cur == h && node != null) {
                count++;
                return;
            }
            if (node == null){
                return;
            }
            cur++;
            countLeaf(cur,h,node.left);
            countLeaf(cur,h,node.right);
        }
    }
}
