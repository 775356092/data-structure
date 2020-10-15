package LeetCode;

/**
 * @description: 第一个错误的版本
 * @author: wang hao
 * @create: 2020-10-15 17:18
 */
public class _278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean isBadVersion(int n){
        return true;
    }
}
