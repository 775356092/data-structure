package LeetCode;

/**
 * @Author: wang hao
 * @Description: 尽可能使字符串相等
 * @Date: 2021/2/5 1:15 下午
 */
public class _1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0;
        int sum = 0;
        while (right < len) {
            sum += cost[right];
            while (sum > maxCost) {
                sum -= cost[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
