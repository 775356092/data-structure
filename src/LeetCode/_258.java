package LeetCode;

/**
 * @description: 各位相加
 * @author: wang hao
 * @create: 2020-10-15 17:39
 */
public class _258 {
    public int addDigits(int num) {
        while (num >= 10) {
            num = numSum(num);
        }
        return num;
    }
    public int numSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
