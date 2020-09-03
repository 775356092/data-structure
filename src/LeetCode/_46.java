package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @description: 全排列
 * @author: wang hao
 * @create: 2020-09-03 15:14
 */
public class _46 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        dfs(new ArrayList<>(), visited, nums);
        return res;
    }

    public void dfs(ArrayList<Integer> list, int[] visited, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i]++;
                dfs(list, visited, nums);
                visited[i]--;
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
