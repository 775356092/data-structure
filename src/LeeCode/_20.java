package LeeCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 有效的括号
 * @author: wang hao
 * @create: 2020-08-14 09:11
 */
public class _20 {
    public static boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        if(s.length()==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }
            Character temp = stack.peek();
            if ((s.charAt(i) == ']' && temp == '[') || (s.charAt(i) == ')' && temp == '(')|| (s.charAt(i) == '}' && temp == '{')) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() <= 0;
    }

    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }
}
