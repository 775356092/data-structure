package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 格雷编码
 * @author: wang hao
 * @create: 2020-10-12 13:53
 */
public class _89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + head);
            }
            head <<= 1;
        }
        return res;
    }
}
