package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 电话号码的字母组合
 * @author: wang hao
 * @create: 2020-08-26 09:04
 */
public class _17 {

     static String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     static ArrayList<String> res = new ArrayList<>();

/*    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        dfs(digits, new StringBuilder(), 0);
        return res;
    }

    public static void dfs(String digits, StringBuilder result, int index) {
        if (index == digits.length()) {
            res.add(result.toString());
            return;
        }
        String temp = map[digits.charAt(index) - '0'];
        for (int j = 0; j < temp.length(); j++) {
            dfs(digits, result.append(temp.charAt(j)), index + 1);
            result.deleteCharAt(result.length() - 1);
        }
    }*/

    public static void main(String[] args) {
        letterCombinations("23");
    }


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        dfs(digits, "", 0);
        return res;
    }

    public static void dfs(String digits, String result, int index) {
        if (index == digits.length()) {
            res.add(result);
            return;
        }
        String temp = map[digits.charAt(index) - '0'];
        for (int j = 0; j < temp.length(); j++) {
            dfs(digits, result + temp.charAt(j), index + 1);
        }
    }
}
