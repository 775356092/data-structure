package LeetCode;

/**
 * @description: 把二叉树累加转换为累加树
 * @author: wang hao
 * @create: 2020-09-21 09:02
 */
public class _1038 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
