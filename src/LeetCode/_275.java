package LeetCode;

/**
 * @description: H指数 II
 * @author: wang hao
 * @create: 2020-10-23 17:00
 */
public class _275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int t = len - mid;
            if (citations[mid] == t) {
                return len - mid;
            }
            if (citations[mid] > t) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return len - i;
    }
}
