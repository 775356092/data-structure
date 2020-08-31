package LeetCode;

import java.util.ArrayList;

/**
 * @description: 叶子相似的树
 * @author: wang hao
 * @create: 2020-08-28 16:07
 */
public class _872 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> res1 = new ArrayList<>();
    ArrayList<Integer> res2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, 1);
        dfs(root2, 2);
        return res1.equals(res2);
    }

    public void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && num == 1) {
            res1.add(root.val);
        }
        if (root.left == null && root.right == null && num == 2) {
            res2.add(root.val);
        }
        else {
            dfs(root.left, num);
            dfs(root.right, num);
        }
    }
}
