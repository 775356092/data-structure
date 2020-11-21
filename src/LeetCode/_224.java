package LeetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 基本计算器
 * @author: wang hao
 * @create: 2020-11-03 13:13
 */
public class _224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, res = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '9';
                continue;
            }
            res += sign * num;
            num = 0;
            if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            if (c == ')') {
                res *= stack.pop();
                res += stack.pop();
            }
            if (c == '+') {
                sign = 1;
            }
            if (c == '-') {
                sign = -1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(-5/2);
    }
}
