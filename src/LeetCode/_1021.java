package LeetCode;

import java.util.ArrayList;

/**
 * @program: data-structure
 * @description: 删除最外层的括号
 * @author: wang hao
 * @create: 2020-05-12 11:27
 */
public class _1021 {
    /**
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     *
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     *
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     *
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 
     */
    public static String removeOuterParentheses(String S) {
        ArrayList<String> list = new ArrayList<>();
        int temp=0;
        int from=0;
        int to=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                temp++;
                to++;
            }else {
                temp--;
                to++;
            }
            if(temp==0){
                list.add(S.substring(from,to));
                from = to;
            }
        }
        StringBuilder res = new StringBuilder();
        for(String s:list){
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(s.length()-1);
            sb.deleteCharAt(0);
            res.append(sb.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = removeOuterParentheses("(()())(())(()(()))");
        System.out.println(s);
    }
}
