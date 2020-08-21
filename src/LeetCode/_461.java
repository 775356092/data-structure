package LeetCode;

/**
 * @program: data-structure
 * @description: 汉明距离
 * @author: wang hao
 * @create: 2020-05-12 13:51
 */
public class _461 {
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     */
    public static int hammingDistance(int x, int y) {
        StringBuilder x1 = new StringBuilder();
        StringBuilder x2 = new StringBuilder();
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            x1.append(x >>> i & 1);
            x2.append(y >>> i & 1);
        }
        for (int i = 0; i <= 31; i++) {
            if (x1.charAt(i) != x2.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
