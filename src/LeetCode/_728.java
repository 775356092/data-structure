package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: 自除数
 * @author: wang hao
 * @create: 2020-05-15 16:01
 */
public class _728 {
    /**
     * 自除数 是指可以被它包含的每一位数除尽的数。
     * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
     * 还有，自除数不允许包含 0 。
     * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int x = i;
            while (x != 0) {
                int divided = x % 10;
                if (divided == 0) {
                    flag = false;
                    break;
                }
                if (!(i % divided == 0)) {
                    flag = false;
                }
                x /= 10;
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = selfDividingNumbers(1, 22);
        System.out.println(integers);
    }
}
