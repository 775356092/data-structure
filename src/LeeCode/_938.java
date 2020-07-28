package LeeCode;

/**
 * @program: data-structure
 * @description: 二叉搜索树的范围和
 * @author: wang hao
 * @create: 2020-05-12 11:43
 */
public class _938 {
    /**
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     * <p>
     * 二叉搜索树保证具有唯一的值。
     */

    int res = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return res;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (node.val <= R && node.val >= L) {
                res += node.val;
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
            if (node.val > L) {
                dfs(node.left, L, R);
            }
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
