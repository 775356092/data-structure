package LeetCode;

/**
 * @description: Excel表序列号
 * @author: wang hao
 * @create: 2020-08-26 15:51
 */
public class _171 {
    //26进制运算
    public static int titleToNumber(String s) {
        int res = 0;
        int y = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'A' + 1;
            int temp = 1;
            for (int j = 0; j < y; j++) {
                temp *= 26;
            }
            y--;
            temp *= x;
            res += temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }
}
