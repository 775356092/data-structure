package LeetCode;

/**
 * @description: 树的子结构
 * @author: wang hao
 * @create: 2020-09-22 16:30
 */
public class O_26 {

    /**
     * 和572题稍有不同，一个是子树，一个是子结构
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return check(s, t) || isSubStructure(s.left, t) || isSubStructure(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
