package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的中序遍历
 * @author: wang hao
 * @create: 2020-09-14 08:51
 */
public class _94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
