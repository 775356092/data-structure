package LeetCode;

import org.junit.Test;

/**
 * @description: 第N个数字
 * @author: wang hao
 * @create: 2020-09-25 14:38
 */
public class _400 {

    // 12345678910111213141516171819...
    // 1位数 1-9        1 * 9
    // 2位数 10-99      2 * 90
    // 3位数 100-999    3 * 900
    // 4位数 1000-9999  4 * 9000
    // s位数            s * 9 * 10 ^ (s - 1)
    public int findNthDigit(int n) {
        int digit = 1;
        long range = 9;
        //确定上界range，几位数digit
        while (n > range) {
            digit++;
            range += (digit * Math.pow(10, digit - 1) * 9);
        }
        //数字是从numStart开始的, 数位是从digitStart开始的, 这里区间左端是开区间(numStart, (digitStart
        int numStart = (int) Math.pow(10, digit - 1) - 1;
        int digitStart = (int) (range - digit * Math.pow(10, digit - 1) * 9);
        //确定从numStart开始需要加多少才能大于等于n
        int t = (n - digitStart) % digit;
        //确定是哪个数字target
        if (t == 0) {
            int target = numStart + (n - digitStart) / digit;
            return Integer.parseInt(Integer.toString(target).substring(digit - 1, digit));
        } else {
            int target = numStart + (n - digitStart) / digit + 1;
            return Integer.parseInt(Integer.toString(target).substring(t - 1, t));
        }
    }

    @Test
    public void test() {
        System.out.println(findNthDigit(900000));
    }
}
