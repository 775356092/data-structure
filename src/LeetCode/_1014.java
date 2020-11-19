package LeetCode;

/**
 * @description: 最佳观光组合
 * @author: wang hao
 * @create: 2020-11-19 09:35
 */
public class _1014 {
    public int maxScoreSightseeingPair(int[] A) {
        // A[i] + i + A[j] - j
        int res = 0, preMax = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            // 想让结果最大，那么我们希望A[i] + i尽可能大
            int post = A[j] - j;
            res = Math.max(res, preMax + post);
            // 更新j + 1之前的最大的A[i] + i
            preMax = Math.max(preMax, A[j] + j);
        }
        return res;
    }
}
