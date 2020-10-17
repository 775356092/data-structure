package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 验证二叉搜索树的后序遍历序列
 * @author: wang hao
 * @create: 2020-09-28 14:03
 */
public class O_33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 1) {
            return true;
        }
        int t = 0;
        while (postorder[t] < postorder[postorder.length - 1]) {
            t++;
        }
        //左边是左子树[0, t - 1]，右边是右子树[t, len - 2], 根是[len - 1]
        for (int k = t; k <= postorder.length - 2; k++) {
            if (postorder[k] < postorder[postorder.length - 1]) {
                return false;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, t)) && verifyPostorder(Arrays.copyOfRange(postorder, t, postorder.length - 1));
    }

    @Test
    public void test() {
        System.out.println(verifyPostorder(new int[]{1, 2, 3, 4, 5}));
    }

}
