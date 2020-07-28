package LeeCode;

import java.util.Stack;

/**
 * @program: data-structure
 * @description: 字符串解码
 * @author: wang hao
 * @create: 2020-05-28 08:43
 */
public class _394 {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     */
    public static String decodeString(String s) {
        Stack<Integer> integer = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //如果是数字，multi一直累加
            if (Character.isDigit(s.charAt(i))) {
                multi = Integer.parseInt(s.charAt(i) + "") + multi * 10;
            } else if (s.charAt(i) == '[') {//如果是左括号，multi入栈，res入栈，刷新一下multi和res
                integer.push(multi);
                string.push(res);
                res = new StringBuilder();
                multi = 0;
            } else if (Character.isLetter(s.charAt(i))) {//如果是字符添加字符到res之后
                res.append(s.charAt(i));
            } else if (s.charAt(i) == ']') {//如果是右括号，出栈
                StringBuilder temp = new StringBuilder();
                StringBuilder sb = string.pop();
                Integer x = integer.pop();
                for (int j = 0; j < x; j++) {
                    temp.append(res);
                }
                res = sb.append(temp);

            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String string = decodeString("2[abc]3[cd]ef");
        System.out.println(string);
    }
}
