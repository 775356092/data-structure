package LeetCode;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-08-27 13:52
 */
public class _1558 {

    //给一个数组arr，初始值都是零，有两种操作，一种是给指定下标的元素加一，另一种是使数组中所有元素乘以二
    //问使arr变为num的最小操作次数
    //0成为5的过程 加一 乘二 乘二 加一 对应二进制为001 010 100 101
    //加一的次数就是二进制1的个数，乘二的次数就是二进制位数减去一
    //数组乘二的次数由数组中的最大数决定
    public static int minOperations(int[] nums) {
        int res = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            res += Integer.bitCount(num);
        }
        res += Integer.toBinaryString(max).length() - 1;
        return res;
    }

    public static void main(String[] args) {
        int i = minOperations(new int[]{1, 5});
        System.out.println(i);
    }
}
