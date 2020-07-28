package LeeCode;

/**
 * @program: data-structure
 * @description: 奇数值单元格的数目
 * @author: wang hao
 * @create: 2020-05-12 14:12
 */
public class _1252 {
    /**
     * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
     *
     * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     *
     * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     *
     * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            //行加一
            for (int j = 0; j < m; j++) {
                arr[row][j]++;
            }
            //列加一
            for (int k = 0; k < n; k++) {
                arr[k][col]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
