package LeeCode;

public class _111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
