package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 组合
 * @author: wang hao
 * @create: 2020-09-08 08:49
 */
public class _77 {

    int len;
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        len = k;
        res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        dfs(1, n, new ArrayList<>());
        return res;
    }

    public void dfs(int index, int n, ArrayList<Integer> list) {
        //递归终止条件是：list 的长度等于 k
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        //i 从 index 开始，保证 在当前循环中，不会重复遍历 之前遍历过的数字
        //搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        //接下来要选择的个数 = len - list.size()
        for (int i = index; i <= n - (len - list.size()) + 1; i++) {
            //添加一个数
            list.add(i);
            //设置下一个搜索起点加一，不允许出现重复的数
            dfs(i + 1, n, list);
            //回溯
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
}
