package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 解码字母到整数映射
 * @author: wang hao
 * @create: 2020-05-14 09:29
 */
public class _1309 {
    /**
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
     * <p>
     * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
     * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
     * 返回映射之后形成的新字符串。
     * <p>
     * 题目数据保证映射始终唯一。
     */

    private static final HashMap<String, String> map = new HashMap<>();

    public static String freqAlphabets(String s) {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");
        map.put("18", "r");
        map.put("19", "s");
        map.put("20", "t");
        map.put("21", "u");
        map.put("22", "v");
        map.put("23", "w");
        map.put("24", "x");
        map.put("25", "y");
        map.put("26", "z");
        StringBuilder sb = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //判断当前字符后两位是否组成xx#形式的字符串
            if (i < s.length() - 2) {
                if (s.charAt(i + 2) == '#') {
                    list.add(s.substring(i, i + 2));
                    i += 2;
                } else if (s.charAt(i + 2) != '#' && s.charAt(i) != '#') {
                    list.add(s.substring(i, i + 1));
                }
            } else {//判断导数第两个字符是否含有'#'
                if (s.charAt(s.length() - 1) != '#') {
                    list.add(s.substring(i, i + 1));
                } else {
                    list.add(s.substring(i + 1, i + 2));
                    break;
                }
            }
        }

        for (String string : list) {
            //string->char
            int i = Integer.parseInt(string);
            char c = (char)(i+'0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = freqAlphabets("26#11#418#5");
        System.out.println(s);
    }
}
