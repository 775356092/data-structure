package LeetCode;

import java.util.Stack;

/**
 * @program: data-structure
 * @description: 化栈为队
 * @author: wang hao
 * @create: 2020-05-15 15:25
 */
public class O_03_04 {
    /**
     * 实现一个MyQueue类，该类用两个栈来实现一个队列。
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public O_03_04() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            int x = stack1.pop();
            stack2.push(x);
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()){
            int x = stack2.pop();
            stack1.push(x);
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack1.isEmpty()) {
            int x = stack1.pop();
            stack2.push(x);
        }
        int res = stack2.peek();
        while (!stack2.isEmpty()){
            int x = stack2.pop();
            stack1.push(x);
        }
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if(stack1.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        O_03_04 queue = new O_03_04();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
