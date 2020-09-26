package LeetCode;

import java.util.ArrayDeque;

/**
 * @description: 滑动窗口最大值
 * @author: wang hao
 * @create: 2020-09-21 14:40
 */
public class _239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        //从大到小
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //clear
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k - 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
