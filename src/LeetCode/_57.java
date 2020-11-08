package LeetCode;

import java.util.ArrayList;

/**
 * @description: 插入区间
 * @author: wang hao
 * @create: 2020-11-04 09:06
 */
public class _57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        // 新区间在右侧没有重合
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        // 新区间在中间有重合
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        // 新区间在左侧没有重合
        while (i < intervals.length) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
