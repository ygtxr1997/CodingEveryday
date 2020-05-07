/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

/**
 * @program: idea
 * @description: 另一种树的子树
 * @author: Lovely Dragon
 * @create: 2020-05-07 08:17
 */
public class IsSubtree {
    //寻找根节点
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (s.val == t.val){
            if (isSame(s,t))
                return true;
        }
        if (isSubtree(s.left,t))
            return true;
        if (isSubtree(s.right,t)){
            return true;
        }
        return false;
    }

    //判断是否为同一棵树
    public boolean isSame(TreeNode s,TreeNode t){
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val){
            return isSame(s.right,t.right) && isSame(s.left,t.left);
        }
        return false;
    }
}
