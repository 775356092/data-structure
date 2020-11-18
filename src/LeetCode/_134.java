package LeetCode;

import org.junit.Test;

/**
 * @description: 加油站
 * @author: wang hao
 * @create: 2020-11-18 09:19
 */
public class _134 {
    // 模拟
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int t = 0, start = i, len = 0;
            while (t >= 0 && len < gas.length) {
                t += gas[start];
                if (t < cost[start]) {
                    break;
                }
                t -= cost[start];
                start = (start + 1) % gas.length;
                len++;
            }
            if (len == gas.length) {
                return i;
            }
        }
        return -1;
    }

    //一次遍历
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int res = -1, curLeft = 0, totalLeft = 0;
        for (int i = 0; i < gas.length; i++) {
            curLeft += (gas[i] - cost[i]);
            totalLeft += (gas[i] - cost[i]);
            if (curLeft < 0) {
                res = i + 1;
                curLeft = 0;
            }
        }
        return totalLeft < 0 ? -1 : res;
    }

    @Test
    public void test() {
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
