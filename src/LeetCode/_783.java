package LeetCode;

/**
 * @description: 二叉搜索树节点最小距离
 * @author: wang hao
 * @create: 2020-10-12 09:19
 */
public class _783 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = (int) 1e6, pre = -1;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != -1) res = Math.min(res, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }
}
