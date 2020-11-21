package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 距离顺序排列矩阵单元格
 * @author: wang hao
 * @create: 2020-11-17 09:12
 */
public class _1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i * C + j;
                res[t][0] = i;
                res[t][1] = j;
            }
        }
        Arrays.sort(res, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        return res;
    }
}
