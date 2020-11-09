package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 最接近原点的K个点
 * @author: wang hao
 * @create: 2020-11-09 09:04
 */
public class _973 {
    // 数组自定义排序
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> distance(o1) - distance(o2));
        return Arrays.copyOfRange(points, 0, K);
    }

    // 优先级队列
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> distance(o1) - distance(o2));
        for (int[] point : points) {
            priorityQueue.offer(point);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    // 快速排序
    public int[][] kClosest3(int[][] points, int K) {
        quickSort(points, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickSort(int[][] arr, int left, int right) {
        if (left > right) return;
        int[] x = arr[left];
        int temp = distance(arr[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && distance(arr[j]) >= temp) {
                j--;
            }
            while (i < j && distance(arr[i]) <= temp) {
                i++;
            }
            if (i < j) {
                int[] t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = x;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public int distance(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}
