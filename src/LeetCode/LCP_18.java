package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description : 早餐组合
 * @Author : wang hao
 * @Date: 2020-09-12 15:03
 */
public class LCP_18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int res = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int len = drinks.length - 1;
        for (int value : staple) {
            while (len >= 0 && value + drinks[len] > x) {
                len--;
            }
            res = (res + len + 1) % 1000000007;
        }
        return res % 1000000007;
    }

    @Test
    public void test() {
        System.out.println(breakfastNumber(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3, 4, 14, 15}, 15));
    }
}
