package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: data-structure
 * @description: 二叉搜索树的第k大节点
 * @author: wang hao
 * @create: 2020-05-15 16:43
 */
public class O_54 {
    /**
     *
     */
    ArrayList<Integer> res = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        recursion(root);
        Collections.sort(res);
        Collections.reverse(res);
        return res.get(k);
    }
    //前序遍历
    public void recursion(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        recursion(root.left);
        recursion(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
