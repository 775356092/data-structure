package LeetCode;

/**
 * @Description : 二进制矩阵中的特殊位置
 * @Author : wang hao
 * @Date: 2020-09-13 10:41
 */
public class _5511 {
    public int numSpecial(int[][] mat) {
        int res = 0;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
