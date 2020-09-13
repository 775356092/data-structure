package LeetCode;

import org.junit.Test;

/**
 * @Description : 速算机器人
 * @Author : wang hao
 * @Date: 2020-09-12 15:03
 */
public class LCP_17 {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                x = x * 2 + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    @Test
    public void test(){
        System.out.println(calculate("AB"));
    }
}
