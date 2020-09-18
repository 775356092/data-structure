package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角 II
 * @author: wang hao
 * @create: 2020-09-18 13:24
 */
public class _119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        if (rowIndex == 0) {
            return temp;
        }
        temp.add(1);
        if (rowIndex == 1) {
            return temp;
        }
        for (int i = 2; i <= rowIndex; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 0; j < temp.size() - 1; j++) {
                res.add(temp.get(j) + temp.get(j + 1));
            }
            res.add(1);
            if (i == rowIndex) {
                return res;
            } else {
                temp = new ArrayList<>(res);
            }
        }
        return null;
    }
}
