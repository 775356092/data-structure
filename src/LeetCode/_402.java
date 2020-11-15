package LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @Description : 删掉K位数字
 * @Author : wang hao
 * @Date: 2020-11-15 20:55
 */
public class _402 {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.getLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder res = new StringBuilder();
        // 判断有没有前导零
        if (!stack.isEmpty() && stack.getFirst() == '0') {
            while (!stack.isEmpty() && stack.getFirst() == '0') {
                stack.removeFirst();
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.removeFirst());
        }
        return res.length() > 0 ? res.toString() : "0";
    }

    @Test
    public void test() {
        System.out.println(removeKdigits("10200", 1));
    }
}
