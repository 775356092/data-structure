package LeetCode;

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
        dfs(new ArrayDeque<>(), visited, nums);
        return res;
    }

    public void dfs(ArrayDeque<Integer> deque, int[] visited, int[] nums) {
        if (deque.size() == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(deque);
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                deque.addLast(nums[i]);
                visited[i]++;
                dfs(deque, visited, nums);
                deque.removeLast();
            }
        }
    }
}
