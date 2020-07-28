package LeeCode;

/**
 * @program: data-structure
 * @description: 二叉搜索树的最近公共祖先
 * @author: wang hao
 * @create: 2020-05-19 14:50
 */
public class _235 {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //两个结点为父结点的左右结点 返回父节点
        //一个结点为父结点，一个为子结点，返回父节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
