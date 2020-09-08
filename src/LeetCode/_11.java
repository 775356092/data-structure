package LeetCode;

import org.junit.Test;

/**
 * @description: 盛最多水的容器
 * @author: wang hao
 * @create: 2020-09-07 17:24
 */
public class _11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        //若向内移动短板，水槽的短板 min(h[i], h[j]) 可能变大，因此水槽面积可能增大。
        //若向内移动长板，水槽的短板 min(h[i], h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
        //所以应该向内移动短板
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, height[left] * (right - left));
                left++;
            } else {
                res = Math.max(res, height[right] * (right - left));
                right--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}
