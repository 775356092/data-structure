package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 子集 Ⅱ
 * @author: wang hao
 * @create: 2020-09-28 14:58
 */
public class _90 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            int[] visited = new int[nums.length];
            dfs(nums, new ArrayList<>(), i, visited, 0);
        }
        return res;
    }

    public void dfs(int[] nums, ArrayList<Integer> path, int size, int[] visited, int index) {
        if (size == path.size()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (visited[i] == 0) {
                visited[i]++;
                path.add(nums[i]);
                dfs(nums, path, size, visited, i + 1);
                path.remove(path.size() - 1);
                visited[i]--;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }


}
