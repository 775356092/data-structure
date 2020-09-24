package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 二叉搜索树中的众数
 * @author: wang hao
 * @create: 2020-09-24 09:04
 */
public class _501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0, curr = 0, count = 0;
    ArrayList<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (curr != root.val) {
            curr = root.val;
            count = 1;
        } else {
            count++;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(curr);
        } else if (count == max) {
            list.add(curr);
        }
        dfs(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        root.right = n1;
        n1.left = n2;
        System.out.println(Arrays.toString(findMode(root)));
    }


}
