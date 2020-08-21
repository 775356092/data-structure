package LeetCode;

import java.util.Stack;

/**
 * @program: data-structure
 * @description: design a min stack
 * @author: wang hao
 * @create: 2020-05-12 10:38
 */
public class _155 {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public _155() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(!minStack.isEmpty()){
            int top = minStack.peek();
            if(top>=x){
                minStack.push(x);
            }
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        int top = minStack.peek();
        if(top == pop){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
