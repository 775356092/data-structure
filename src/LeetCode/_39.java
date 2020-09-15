package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    //39.组合总数
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);//排序为了方便剪枝
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        //index为下一轮搜索的起点
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {//剪枝
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);//回溯
        }
    }

    @Test
    public void test() {
        List<List<Integer>> res = combinationSum(new int[]{8, 7, 4, 3}, 11);
        System.out.println(res);
    }
//
//    List<List<Integer>> res;
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        res = new ArrayList<>();
//        dfs(candidates, target, new ArrayList<>(), 0);
//        return res;
//    }
//
//    public void dfs(int[] candidates, int target, ArrayList<Integer> list, int index) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            list.add(candidates[i]);
//            dfs(candidates, target - candidates[i], list, i);
//            list.remove(list.size() - 1);
//        }
//    }
}
