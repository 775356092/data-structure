package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 两地调度
 * @author: wang hao
 * @create: 2020-11-25 14:33
 */
public class _1029 {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        return res;
    }
}
