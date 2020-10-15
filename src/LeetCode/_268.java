package LeetCode;

/**
 * @description: 丢失的数字
 * @author: wang hao
 * @create: 2020-10-15 17:23
 */
public class _268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        // [0, len]
        boolean[] visited = new boolean[len + 1];
        for (int num : nums) {
            visited[num] = true;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }
}
