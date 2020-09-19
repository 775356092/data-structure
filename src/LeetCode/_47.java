package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 全排列 II
 * @author: wang hao
 * @create: 2020-09-03 15:24
 */
public class _47 {
    HashSet<List<Integer>> set = new HashSet<>();


/*    public List<List<Integer>> permuteUnique(int[] nums) {
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
    }*/
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(visited, nums, new ArrayList<>());
        return res;
    }

    public void dfs(int[] visited, int[] nums, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            if (visited[i] == 0) {
                visited[i]++;
                path.add(nums[i]);
                dfs(visited, nums, path);
                path.remove(path.size() - 1);
                visited[i]--;
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
