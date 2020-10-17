package LeetCode;

/**
 * @description: 二叉搜索树的最小绝对差
 * @author: wang hao
 * @create: 2020-10-12 08:56
 */
public class _530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = (int) 1e6, pre = -1;

    public int getMinimumDifference(TreeNode root) {
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
