package LeetCode;

import java.util.Arrays;

/**
 * @description: 根据前序和后序遍历构造二叉树
 * @author: wang hao
 * @create: 2020-09-25 10:00
 */
public class _889 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) return root;
        int t = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[1]) {
                t = i + 1; // 左子树的长度
                break;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, t + 1), Arrays.copyOfRange(post, 0, t));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, t + 1, len), Arrays.copyOfRange(post, t, len - 1));
        return root;
    }
}
