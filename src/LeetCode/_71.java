package LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @description: 简化路径
 * @author: wang hao
 * @create: 2020-10-12 17:05
 */
public class _71 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String t : arr) {
            if (t.equals("") || t.equals(".")) {
                continue;
            }
            if (t.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeFirst();
                }
            } else {
                stack.addFirst(t);
            }
        }
        StringBuilder res = new StringBuilder("/");
        if (stack.isEmpty()) {
            return res.toString();
        }
        while (!stack.isEmpty()) {
            res.append(stack.removeLast()).append("/");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
