package LeetCode;

/**
 * @program: data-structure
 * @description: 对称二叉树
 * @author: wang hao
 * @create: 2020-05-21 16:25
 */
public class _101 {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    //bfs
    /*public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<TreeNode> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                list.add(node);
                count--;
            }
            for (int i = 0; i < list.size() / 2; i++) {
                if (list.get(i) == null && list.get(list.size() - i - 1) == null) {
                    continue;
                }
                if ((list.get(i) == null && list.get(list.size() - i - 1) != null) || (list.get(i) != null && list.get(list.size() - i - 1) == null)) {
                    return false;
                }
                if (list.get(i).val != list.get(list.size() - i - 1).val) {
                    return false;
                }
            }
        }
        return true;
    }*/

    //dfs
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    //什么时候两棵树是对称的？拥有相同的root结点，root的左子树和右子树对称，root的右子树和左子树对称
    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
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
