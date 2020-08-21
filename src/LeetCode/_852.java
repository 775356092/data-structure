package LeetCode;

/**
 * @program: data-structure
 * @description: 山脉数组的峰顶索引
 * @author: wang hao
 * @create: 2020-05-18 15:08
 */
public class _852 {
    /**
     * 我们把符合下列属性的数组 A 称作山脉：
     * <p>
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     */
    public int peakIndexInMountainArray(int[] A) {
        if (A.length < 3) {
            return -1;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return i-1;
            }
        }
        return -1;
    }
}
