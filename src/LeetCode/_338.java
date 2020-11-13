package LeetCode;

/**
 * @description: 比特位计数
 * @author: wang hao
 * @create: 2020-11-13 15:58
 */
public class _338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // 奇数一定是偶数加1
            if ((i & 1) == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                // 偶数除以2 1的个数相等 1, 2, 4, 8
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
