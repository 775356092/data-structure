package LeetCode;

import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 打家劫舍 III
 * @author: wang hao
 * @create: 2020-05-29 10:18
 */
public class _337 {
    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return f(root, map);
    }

    /**
     * 记忆化-动态规划
     *
     * 当前结点偷了，子节点就不能偷，但是可以偷孙子结点 money = root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val
     * 当前结点偷 可以偷两个子节点， money = root.left.val + root.right.val
     * 比较当前结点能偷到最多的钱
     *
     * @param root
     * @param map
     * @return
     */
    public int f(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += f(root.left.left, map) + f(root.left.right, map);
        }
        if (root.right != null) {
            money += f(root.right.left, map) + f(root.right.right, map);
        }
        int res = Math.max(money, f(root.left,map) + f(root.right,map));
        map.put(root,res);
        return res;
    }


}
