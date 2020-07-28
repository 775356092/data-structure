package LeeCode;

/**
 * @program: data-structure
 * @description: 不用加减乘除做加法
 * @author: wang hao
 * @create: 2020-05-22 10:32
 */
public class O_65 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     */
    // 1 1 0 0
    // 1 0 1 0
    //无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
    //sum = a^b + a&b<<1
    public static int add(int a, int b) {
        //进位为0跳出循环
        while (b != 0) {
            int c = (a & b) << 1; //c是进位
            a ^= b; //无进位和
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1,7));
    }
}
