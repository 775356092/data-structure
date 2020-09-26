package LeetCode;

/**
 * @description: 监控二叉树
 * @author: wang hao
 * @create: 2020-09-22 08:56
 */
public class _968 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 三种状态
    // 0 --> 当前节点待覆盖
    // 1 --> 当前节点已被覆盖
    // 2 --> 当前节点安装了摄像头
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    public int dfs(TreeNode root) {
        // 定义空节点已被覆盖
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 左右节点没有被覆盖
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 左右节点都被覆盖但是左右节点都没有安装摄像头
        if (left == 1 && right == 1) {
            return 0;
        }
        // 左右节点至少存在一个摄像头
        if (left + right >= 3) {
            return 1;
        }
        return -1;
    }
}
