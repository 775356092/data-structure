package LeetCode;

import org.junit.Test;

/**
 * @Description : 早餐组合
 * @Author : wang hao
 * @Date: 2020-09-12 15:03
 */
public class LCP_19 {
    public int minimumOperations(String leaves) {
        int res = 0;
        int r = 0;
        for (int i = 0; i < leaves.length(); i++) {
            if (leaves.charAt(i) != 'y') {
                r++;
            }else {
                break;
            }
        }
        if (r == leaves.length()) {
            return 1;
        }
        if (leaves.charAt(0) != 'r') res++;
        if (leaves.charAt(leaves.length() - 1) != 'r') res++;
        int left = 0, right = 0;
        for (int i = 1; i < leaves.length() - 1; i++) {
            if (leaves.charAt(i) == 'y') {
                left = i;
                break;
            }
        }
        for (int i = leaves.length() - 2; i > left; i--) {
            if (leaves.charAt(i) == 'y') {
                right = i;
                break;
            }
        }
        int count1 = 1;
        int count2 = 0;
        for (int i = left + 1; i <= right; i++) {
            if (leaves.charAt(i) == 'r') {
                count1++;
            }else {
                count2++;
            }
        }

        return res;
    }


    @Test
    public void test() {
        System.out.println(minimumOperations("ryrrrryyyyyr"));
    }
}
