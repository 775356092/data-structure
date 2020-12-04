package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 用最少数量的箭引爆气球
 * @author: wang hao
 * @create: 2020-11-23 10:02
 */
public class _452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) return 0;
        int res = 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                res++;
            }
        }
        return res;
    }
}
