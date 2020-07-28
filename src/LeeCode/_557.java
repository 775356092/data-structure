package LeeCode;

/**
 * @program: data-structure
 * @description: 反转字符串中的单词 III
 * @author: wang hao
 * @create: 2020-05-18 15:02
 */
public class _557 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     */

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] split = s.split("\\s+");
        for (String string : split) {
            String s1 = reverse(string);
            res.append(s1);
            res.append(" ");
        }
        String ans = res.toString().trim();
        return ans;
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
