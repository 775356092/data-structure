package LeetCode;

/**
 * @description: 路径总和
 * @author: wang hao
 * @create: 2020-08-28 13:21
 */
public class _112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == target;
        } else {
            return dfs(root.left, sum, target) || dfs(root.right, sum, target);
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
