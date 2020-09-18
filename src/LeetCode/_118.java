package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: wang hao
 * @create: 2020-09-18 12:55
 */
public class _118 {
    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(new ArrayList<>(temp));
        if (numRows == 1) {
            return res;
        }
        temp.add(1);
        res.add(new ArrayList<>(temp));
        if (numRows == 2) {
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            for (int j = 0; j < temp.size() - 1; j++) {
                ans.add(temp.get(j) + temp.get(j + 1));
            }
            ans.add(1);
            res.add(ans);
            temp = new ArrayList<>(ans);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(generate(5));
    }
}
