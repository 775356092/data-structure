package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合总数 III
 * @author: wang hao
 * @create: 2020-09-09 11:02
 */
public class _216 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void dfs(int target, int len, ArrayList<Integer> list, int index) {
        if (len < list.size()) {
            return;
        }
        if (target == 0 && len == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (i > target) {
                break;
            }
            list.add(i);
            dfs(target - i, len, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum3(3,7));
    }
}
