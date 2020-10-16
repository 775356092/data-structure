package LeetCode;

import java.util.HashSet;

/**
 * @description: 快乐数
 * @author: wang hao
 * @create: 2020-10-16 13:03
 */
public class _202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            n = powN(n);
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return false;
            }
        }
        return true;
    }

    public int powN(int n) {
        int res = 0;
        while (n != 0) {
            int t = n % 10;
            res += t * t;
            n /= 10;
        }
        return res;
    }
}
