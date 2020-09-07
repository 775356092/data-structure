package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @description: 前k个高频元素
 * @author: wang hao
 * @create: 2020-09-07 08:53
 */
public class _347 {

    /**
     * Entry<K, V> 根据value值排序
     * 使用优先级队列PriorityQueue
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> map.get(i2) - map.get(i1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 基于快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] arr = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[index][0] = entry.getKey();
            arr[index][1] = entry.getValue();
            index++;
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i][0];
        }
        return res;
    }

    /**
     * 二维数组根据arr[i][1]逆序排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[][] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp1 = arr[left][0];
        int temp2 = arr[left][1];
        while (i < j) {
            while (i < j && arr[j][1] <= temp2) {
                j--;
            }
            while (i < j && arr[i][1] >= temp2) {
                i++;
            }
            if (i < j) {
                int x = arr[i][0];
                int y = arr[i][1];
                arr[i][0] = arr[j][0];
                arr[i][1] = arr[j][1];
                arr[j][0] = x;
                arr[j][1] = y;
            }
        }
        arr[left][0] = arr[i][0];
        arr[left][1] = arr[i][1];
        arr[i][0] = temp1;
        arr[i][1] = temp2;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1}, 1)));
    }

}
