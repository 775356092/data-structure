package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 扑克牌中的顺序
 * @author: wang hao
 * @create: 2020-09-21 14:11
 */
public class O_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int min = -1;
        int max = nums[nums.length - 1];
        int index = 0;
        //[0,0,...]
        for (int value : nums) {
            if (value != 0) {
                min = value;
                break;
            } else {
                zero++;
            }
            index++;
        }
        if (zero > 3) {
            return false;
        }
        for (int i = index; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return max - min < 5;
    }

    @Test
    public void test() {
        System.out.println(isStraight(new int[]{0, 0, 8, 4, 5}));
    }
}
