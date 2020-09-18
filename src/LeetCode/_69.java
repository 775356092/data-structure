package LeetCode;

/**
 * @description: x的平方根
 * @author: wang hao
 * @create: 2020-09-18 10:30
 */
public class _69 {
    /**
     * 二分查找 粗略的认定下界为0，上界为x
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //res^2 <= x
        int res = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
