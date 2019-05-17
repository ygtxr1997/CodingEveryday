//真香
//使用BST来解决问题
public class Solution{
    class TreeNode {
        int val;//当前结点的值
        int count;//当前结点的左子树的结点个数（包括各结点重复次数）
        int dup;//当前结点重复出现次数
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            count = 0;
            val = x;
            dup = 1;
            left = null;
            right = null;
        }
    }

    //插入过程：从根结点开始遍历二分查找树
    private int insert(TreeNode root, int val){
        int count = 0;
        while (true){
            if(root.val == val){//如果val在之前出现过了，更新对应结点的dup，跳出循环
                root.dup++;
                count += root.count;
                break;
            }
            else if(val > root.val){//如果val大于当前结点，那么更新count，进入右子树
                count += (root.count + root.dup);
                if(root.right != null){
                    root = root.right;
                }
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            }
            else {//如果val小于当前结点，那么说明当前结点的左子树会增加一个成员/某个成员会多重复一次，那么在进入左子树之前，更新当前结点的count
                root.count++;
                if(root.left != null){
                    root = root.left;
                }
                else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }

        return count;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> outPut = new LinkedList<>();
        if(nums.length < 1)
            return outPut;
            
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        outPut.add(0, 0);
        for(int i = nums.length - 2; i >= 0; i--){
            outPut.add(0, insert(root, nums[i]));
        }

        return outPut;
    }
}