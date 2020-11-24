package LeetCode;

/**
 * @description: 完全二叉树的节点个数
 * @author: wang hao
 * @create: 2020-11-24 10:57
 */
public class _222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = level(root.left);
        int right = level(root.right);
        if (left == right) {
            // 左子树是满二叉树
            return countNodes(root.right) + (1 << left);
        } else {
            // 右子树是满二叉树
            return countNodes(root.left) + (1 << right);
        }
    }

    // 完全二叉树的层数
    public int level(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
