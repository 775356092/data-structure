package LeeCode;

import java.util.Arrays;

public class O_04_02 {
    //面试题 04.02. 最小高度树
    //给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return node;
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
