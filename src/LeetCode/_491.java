package LeetCode;

import java.util.*;

/**
 * @description: 递增子序列
 * @author: wang hao
 * @create: 2020-08-25 08:57
 */
public class _491 {

    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * <p>
     * 说明:
     * 1.给定数组的长度不会超过15。
     * 2.数组中的整数范围是 [-100,100]。
     * 3.给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     */

//     static  Set<List<Integer>> res = new HashSet<>();
//
//    public static List<List<Integer>> findSubsequences(int[] nums) {
//        dfs(nums, new ArrayList<>(), 0);
//        return new ArrayList<>(res);
//    }
//
//    private static void dfs(int[] nums, List<Integer> list, int index) {
//        if (list.size() >= 2) {
//            res.add(new ArrayList<>(list));
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
//                list.add(nums[i]);
//                dfs(nums, list, i + 1);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        findSubsequences(new int[]{4,5,6,7});
//    }


    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> list, int index) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        int[] arr = new int[201];
        for (int i = index; i < nums.length; i++) {
            if (arr[nums[i] + 100] == 1) {
                continue;
            }
            arr[nums[i] + 100]++;
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                dfs(nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        findSubsequences(new int[]{4, 5, 6, 7});
    }


//    static List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        dfs(nums, new ArrayList<>(), 0);
//        return new ArrayList<>(res);
//    }
//
//    private void dfs(int[] nums, List<Integer> list, int index) {
//        if (index >= nums.length) {
//            if (list.size() >= 2) {
//                res.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        // 把第 index 个元素加进 list 中
//        if (list.size() == 0 || nums[index] >= list.get(list.size() - 1)) {
//            list.add(nums[index]);
//            dfs(nums, list, index + 1);
//            list.remove(list.size() - 1);
//        }
//        if (index > 0 && !list.isEmpty() && nums[index] == list.get(list.size() - 1)) {
//            return;
//        }
//        // 不把第 index 个元素加进 list 中
//        dfs(nums, list, index + 1);
//    }

}
