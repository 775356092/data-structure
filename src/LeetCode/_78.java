package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 子集
 * @Author : wang hao
 * @Date: 2020-09-20 12:18
 */
public class _78 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int[] visited = new int[nums.length];
            dfs(nums, new ArrayList<>(), i, 0, visited);
        }
        return res;
    }

    public void dfs(int[] nums, ArrayList<Integer> path, int count, int index, int[] visited) {
        if (count == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 0) {
                path.add(nums[i]);
                visited[i]++;
                dfs(nums, path, count, i + 1, visited);
                visited[i]--;
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
