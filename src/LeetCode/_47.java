package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 全排列 II
 * @author: wang hao
 * @create: 2020-09-03 15:24
 */
public class _47 {
    HashSet<List<Integer>> set = new HashSet<>();
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] visited = new int[nums.length];
        dfs(visited, nums, new ArrayList<>());
        res.addAll(set);
        return res;
    }

    public void dfs(int[] visited, int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i]++;
                list.add(nums[i]);
                dfs(visited, nums, list);
                list.remove(list.size() - 1);
                visited[i]--;
            }
        }
    }
}
