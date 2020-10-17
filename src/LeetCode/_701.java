package LeetCode;

/**
 * @description: 二叉搜索树的插入操作
 * @author: wang hao
 * @create: 2020-09-30 08:55
 */
public class _701 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode t = root;
        while (t != null) {
            if (t.val > val) {
                if (t.left == null) {
                    t.left = new TreeNode(val);
                    break;
                } else {
                    t = t.left;
                }
            } else {
                if (t.right == null) {
                    t.right = new TreeNode(val);
                    break;
                } else {
                    t = t.right;
                }
            }
        }
        return root;
    }

    /**
     * 递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }
        return root;
    }

}
