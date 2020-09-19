package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 合并区间
 * @author: wang hao
 * @create: 2020-09-18 15:53
 */
public class _56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        //Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        //Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        quickSort(intervals, 0, intervals.length - 1);
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int lr = last[1];
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l <= lr) {
                last[1] = Math.max(r, lr);
            } else {
                res.add(new int[]{l, r});
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public void quickSort(int[][] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int[] temp = nums[left];
        while (i < j) {
            while (j > i && nums[j][0] >= temp[0]) {
                j--;
            }
            while (i < j && nums[i][0] <= temp[0]) {
                i++;
            }
            if (i < j) {
                int[] t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
