package LeetCode;

import org.junit.Test;

/**
 * @description: 移动零
 * @author: wang hao
 * @create: 2020-09-18 14:58
 */
public class _283 {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            }else {
                swap(nums, i , i - count);
            }
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
