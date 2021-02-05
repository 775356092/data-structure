package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: wang hao
 * @Description: 滑动窗口中位数
 * @Date: 2021/2/5 1:57 下午
 */
public class _480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = dualHeap.getMedian();
        for (int i = k; i < nums.length; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.remove(nums[i - k]);
            res[i - k + 1] = dualHeap.getMedian();
        }
        return res;
    }

    class DualHeap {
        // 大根堆，维护较小的一半元素
        private PriorityQueue<Integer> small;
        // 小根堆，维护较大的一半元素
        private PriorityQueue<Integer> big;
        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        private HashMap<Integer, Integer> delayed;
        private int k;

        private int smallSize;
        private int bigSize;

        public DualHeap(int k) {
            this.small = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            this.big = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.bigSize = 0;
        }

        public void insert(int num) {
            if (smallSize == 0 || num < small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                big.offer(num);
                bigSize++;
            }
            makeBalance();
        }

        public void remove(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                bigSize--;
                if (num == big.peek()) {
                    prune(big);
                }
            }
            makeBalance();
        }

        public double getMedian() {
            if (k % 2 == 1) {
                return small.peek();
            } else {
                return ((double)small.peek() + (double)big.peek()) / 2;
            }
        }

        // 不断地弹出 heap 的堆顶元素，并且更新哈希表
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        // 维持大顶堆(small)的元素个数大于等于小顶堆(big)的元素个数（bigSize == smallSize || bigSize + 1 == smallSize）
        private void makeBalance() {
            if (smallSize > bigSize + 1) {
                big.offer(small.poll());
                smallSize--;
                bigSize++;
                // small 堆顶元素被移除，需要进行 prune
                prune(small);
            } else if (smallSize < bigSize) {
                small.offer(big.poll());
                smallSize++;
                bigSize--;
                // large 堆顶元素被移除，需要进行 prune
                prune(big);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 3)));
    }
}
