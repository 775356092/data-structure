package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _5495 {
    /**
     * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。
     * 现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。
     * 举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
     * <p>
     * 请你以数组形式返回经过次数最多的扇区，按扇区编号 升序 排列。
     */

    public static List<Integer> mostVisited(int n, int[] rounds) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] count = new int[n];
        int x = rounds[0];
        int y = rounds[1];
        if (x <= y) {
            for (int j = x; j <= y; j++) {
                count[j - 1]++;
            }
        } else {
            while (x <= n) {
                count[x - 1]++;
                x++;
            }
            for (int j = 1; j <= y; j++) {
                count[j - 1]++;
            }
        }
        for (int i = 1; i < rounds.length - 1; i++) {
            int left = rounds[i];
            int right = rounds[i + 1];
            int temp = left;
            if (left <= right) {
                for (int j = left; j <= right; j++) {
                    count[j - 1]++;
                }
            } else {
                while (left <= n) {
                    count[left-1]++;
                    left++;
                }
                for (int j = 1; j <= right; j++) {
                    count[j - 1]++;
                }
            }
            count[temp - 1]--;
        }
        int max = 0;
        for (int item : count) {
            max = Math.max(max, item);
        }
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                res.add(i + 1);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = mostVisited(7, new int[]{1,3,5,7});
        System.out.println(integers);
    }
}
