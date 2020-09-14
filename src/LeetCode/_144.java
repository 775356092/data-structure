package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的前序遍历
 * @author: wang hao
 * @create: 2020-09-14 09:22
 */
public class _144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
