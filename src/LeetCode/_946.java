package LeetCode;

import java.util.ArrayDeque;

/**
 * @description: 验证栈序列
 * @author: wang hao
 * @create: 2020-09-22 15:57
 */
public class _946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int value : pushed) {
            stack.addLast(value);
            while (!stack.isEmpty() && popped[j] == stack.getLast()) {
                stack.removeLast();
                j++;
            }
        }
        return stack.size() == 0;
    }
}
