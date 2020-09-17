package LeetCode;

import org.junit.Test;

/**
 * @description: 接雨水
 * @author: wang hao
 * @create: 2020-09-16 11:27
 */
public class _42 {

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap(int[] height) {
        //lm代表l之前最高高度，rm代表r之后最高高度
        //当lm<lr, 比较height[l]和lm的高度
        //当lm>lr
        int l = 0, r = height.length - 1;
        int res = 0;

        return res;
    }

    /**
     * 按列求，每次统计左边最高的墙和右边最高的墙
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lm = 0, rm = 0;
            //左边最高的墙
            for (int j = i - 1; j >= 0; j--) {
                lm = Math.max(lm, height[j]);
            }
            //右边最高的墙
            for (int j = i + 1; j < height.length; j++) {
                rm = Math.max(rm, height[j]);
            }
            int h = Math.min(lm, rm);
            res += h <= height[i] ? 0 : h - height[i];
        }
        return res;
    }

    @Test
    public void tes() {
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
