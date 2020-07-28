package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 和为零的N个唯一整数
 * @author: wang hao
 * @create: 2020-05-12 15:27
 */
public class _1304 {
    /**
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     */
    public static int[] sumZero(int n) {
        int res[] = new int[n];
        if (n % 2 != 0) {
            res[0] = 0;
            for (int i = 1; i < n; i += 2) {
                res[i] = i;
                res[i + 1] = i * (-1);
            }
        } else {
            for (int i = 1; i < n; i += 2) {
                res[i - 1] = i;
                res[i] = i * (-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sumZero(4);
        System.out.println(Arrays.toString(ints));
    }
}
