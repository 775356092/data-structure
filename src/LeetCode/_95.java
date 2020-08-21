package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 不同的二叉搜索树 II
 * @author: wang hao
 * @create: 2020-07-21 08:52
 */
public class _95 {
    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     */
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        return generate(1,n);
    }

    public List<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            TreeNode treeNode = new TreeNode(start);
            list.add(treeNode);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

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
}
