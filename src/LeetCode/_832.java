package LeetCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 翻转图像
 * @author: wang hao
 * @create: 2020-05-14 09:12
 */
public class _832 {
    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * <p>
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * <p>
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int res[][] = new int[row][col];
        //水平翻转
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                res[i][col - j - 1] = A[i][j];
            }
        }
        //0->1 & 1->0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        System.out.println(Arrays.toString(res));
    }
}
