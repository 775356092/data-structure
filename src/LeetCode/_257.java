package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的所有路径
 * @author: wang hao
 * @create: 2020-08-28 13:33
 */
public class _257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += (root.val + "");
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        } else {
            s += "->";
            dfs(root.left, s);
            dfs(root.right, s);
        }
    }
}
