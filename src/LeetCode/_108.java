package LeetCode;

/**
 * @program: data-structure
 * @description: 将有序数组转换为二叉搜索树
 * @author: wang hao
 * @create: 2020-05-18 13:31
 */
public class _108 {
    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = convert(0, nums.length - 1, nums);
        return root;
    }

    //数组转换为二叉平衡搜索树
    public TreeNode convert(int left, int right, int nums[]) {
        if (left > right) {
            return null;
        }
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = convert(left, p - 1, nums);
        root.right = convert(p + 1, right, nums);
        return root;
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
