package LeetCode;

import java.util.PriorityQueue;

/**
 * @description: 数据流的中位数
 * @author: wang hao
 * @create: 2020-10-09 10:44
 */
public class _295 {

    class MedianFinder {

        private int count;
        private PriorityQueue<Integer> maxheap;//3,2,1
        private PriorityQueue<Integer> minheap;//4,5,6

        public MedianFinder() {
            count = 0;
            //大顶堆, 从大到小, 我们要最大值
            maxheap = new PriorityQueue<>((p, q) -> q - p);
            //小顶堆, 从小到大, 我们要最小值
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            //保证大顶堆的大小等于小顶堆的大小, 或者大顶堆的大小比小顶堆的大小大1
            //保证大顶堆的堆顶元素要小于小顶堆的堆顶元素
            count += 1;
            maxheap.offer(num);
            minheap.add(maxheap.poll());
            // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆(大堆顶大小要大于等于小堆顶)
            if (count % 2 != 0) {
                maxheap.add(minheap.poll());
            }
        }

        public double findMedian() {
            if (count % 2 == 0) {
                return (double) (maxheap.peek() + minheap.peek()) / 2;
            } else {
                return (double) maxheap.peek();
            }
        }
    }

}
