package LeetCode;

/**
 * @description: 验证二叉搜索树
 * @author: wang hao
 * @create: 2020-08-28 16:54
 */
public class _98 {
    /**
     * 中序遍历得到的结果是递增的
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(isValidBST(node1));
    }
}
