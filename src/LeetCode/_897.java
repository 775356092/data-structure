package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 递增顺序查找树
 * @author: wang hao
 * @create: 2020-08-31 09:49
 */
public class _897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(list, root);
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        for (int val : list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return res.right;
    }

    //中序遍历
    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }
}
