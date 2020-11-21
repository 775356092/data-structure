package LeetCode;

import java.util.ArrayDeque;

/**
 * @description: 用栈实现队列
 * @author: wang hao
 * @create: 2020-11-16 16:37
 */
public class _232 {
    class MyQueue {
        ArrayDeque<Integer> stackPush;
        ArrayDeque<Integer> stackPop;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackPush = new ArrayDeque<>();
            stackPop = new ArrayDeque<>();
        }

        /**
         * 只有stackPop未空时，才将stackPush内的元素倒入stackPop中
         */
        public void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.addLast(stackPush.removeLast());
                }
            }
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushToPop();
            stackPush.addLast(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            pushToPop();
            return stackPop.removeLast();
        }

        /** Get the front element. */
        public int peek() {
            pushToPop();
            return stackPop.getLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            pushToPop();
            return stackPop.isEmpty();
        }
    }
}
