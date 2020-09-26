package LeetCode;

/**
 * @description: 把二叉搜索树转换为累加树
 * @author: wang hao
 * @create: 2020-09-21 08:52
 */
public class _538 {
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
