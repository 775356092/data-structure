package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: 和为s的连续正数序列
 * @author: wang hao
 * @create: 2020-05-19 14:00
 */
public class O_57_II {
    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     */
    // 1,2,3,4,5,6,7,8  15
    public static int[][] findContinuousSequence(int target) {
        if (target == 1 || target == 2) {
            return new int[0][];
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        int first = 1;
        int last = (target >> 1) + 1;
        int sum = 0;
        for (; first <= last; first++) {
            ArrayList<Integer> list = new ArrayList<>();
            sum = first;
            boolean flag = false;
            for (int j = first + 1; j <= last && sum <= target; j++) {
                sum += j;
                if (sum == target) {
                    flag = true;
                    for (int i = first; i <= j; i++) {
                        list.add(i);
                    }
                    break;
                }
            }
            if (flag) {
                res.add(list);
            }
        }
        //return res;
        //List<List<Integer>> --> int[][]
        int ans[][] = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> l = res.get(i);
            ans[i] = new int[l.size()];
            for (int j = 0; j < l.size(); j++) {
                ans[i][j] = l.get(j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(1);
    }
}
