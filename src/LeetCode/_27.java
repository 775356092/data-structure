package LeetCode;

import org.junit.Test;

/**
 * @description: 移除元素
 * @author: wang hao
 * @create: 2020-09-07 13:25
 */
public class _27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    @Test
    public void test(){
        removeElement(new int[]{1,3,4,5,6,7,8,9},6);
    }
}
