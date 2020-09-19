package LeetCode;

/**
 * @description: 跳跃游戏 II
 * @author: wang hao
 * @create: 2020-09-15 14:22
 */
public class _45 {

    /**
     * 贪心 逆向找前一个最远的跳跃位置
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int res = 0;
        int pos = nums.length - 1;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 贪心 从前往后找每次能跳的最远的位置
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int res = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                res++;
            }
        }
        return res;
    }

}
