package LeetCode;

import java.util.PriorityQueue;

/**
 * @description: 数据流的中位数
 * @author: wang hao
 * @create: 2020-10-09 10:44
 */
public class _295 {

    class MedianFinder {
        private PriorityQueue<Integer> maxheap;
        private PriorityQueue<Integer> minheap;

        public MedianFinder() {
            maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxheap.size() == minheap.size()) {
                maxheap.offer(num);
                minheap.offer(maxheap.poll());
            } else {
                minheap.offer(num);
                maxheap.offer(minheap.poll());
            }
        }

        public double findMedian() {
            return maxheap.size() == minheap.size() ? (maxheap.peek() + minheap.peek()) / 2.0 : minheap.peek();
        }
    }

}
