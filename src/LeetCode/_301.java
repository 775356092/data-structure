package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 删除无效的括号
 * @author: wang hao
 * @create: 2020-09-10 09:19
 */
public class _301 {
    /**
     * 一个有效的括号字符串，左括号的数量必须等于右括号的数量，任意前缀左括号的数量必须大于等于右括号的数量
     */

    ArrayList<String> res = new ArrayList<>();

/*    HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        //统计要删除多少的左括号，右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }
            if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        dfs(s, "", 0, 0, l, r);
        return new ArrayList<>(set);
    }

    public void dfs(String s, String path, int index, int count, int l, int r) {
        if (count < 0) {
            return;
        }
        if (index == s.length()) {
            if (count == 0) {
                set.add(path);
            }
            return;
        }
        char c = s.charAt(index);
        if (c != ')' && c != '(') {
            dfs(s, path + c, index + 1, count, l, r);
        } else if (c == '(') {
            int next = index;
            while (next < s.length() && s.charAt(next) == '(') next++;
            int num = next - index;
            if (num > l) {
                dfs(s, path + "(".repeat(num - l), next, count + (num - l), 0, r);
            } else {
                dfs(s, path, next, count, l - num, r);
            }
            if (l > 0) {
                dfs(s, path + "(", index + 1, count + 1, l, r);
            }
        } else {
            int next = index;
            while (next < s.length() && s.charAt(next) == ')') next++;
            int num = next - index;
            if (num > r) {
                dfs(s, path + ")".repeat(num - r), next, count - (num - r), l, 0);
            } else {
                //都删了
                dfs(s, path, next, count, l, r - num);
            }
            if (r > 0) {
                //dfs(s, path + ")".repeat(num), next, count - num, l, r);
                dfs(s, path + ")", index + 1, count - 1, l, r);
            }
        }
    }*/

/*    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        //统计要删除多少的左括号，右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }
            if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        dfs(s, "", 0, 0, l, r);
        return res;
    }

    public void dfs(String s, String path, int index, int count, int l, int r) {
        if (index == s.length()) {
            if (count == 0) {
                res.add(path);
            }
            return;
        }
        char c = s.charAt(index);
        if (c != ')' && c != '(') {
            dfs(s, path + c, index + 1, count, l, r);
        } else if (c == '(') {
            int next = index;
            while (next < s.length() && s.charAt(next) == '(') {
                next++;
            }
            l -= next - index;
            for (int i = next - index; i >= 0; i--) {
                if (l >= 0) {
                    dfs(s, path, next, count, l, r);
                }
                path += '(';
                count++;
                l++;
            }
        } else {
            int next = index;
            while (next < s.length() && s.charAt(next) == ')') {
                next++;
            }
            r -= next - index;
            for (int i = next - index; i >= 0; i--) {
                if (r >= 0 && count >= 0) {
                    dfs(s, path, next, count, l, r);
                }
                path += ')';
                count--;
                r++;
            }
        }
    }*/


    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        //统计要删除多少的左括号，右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }
            if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        System.out.println("我们一共要删除：" + l + "个左括号，" + r + "个右括号");
        dfs(s, 0, l, r);
        return res;
    }

    public void dfs(String s, int index, int l, int r) {
        if (l == 0 && r == 0) {
            System.out.println("验证字符串 " + s + "是否合法...");
            if (check(s)) {
                System.out.println(s + " 验证合法，添加到结果集当中");
                res.add(s);
            }
            System.out.println(s + " 验证非法");
            return;
        }
        System.out.println("从下标:" + index + "开始遍历字符串 " + s);
        for (int i = index; i < s.length(); i++) {
            System.out.println("下标i=" + i + "，当前字符为：" + s.charAt(i));
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                System.out.println("和上一个字符相同跳过");
                continue;
            }
            if (l > 0 && s.charAt(i) == '(') {
                System.out.println("删除第" + (i + 1) + "个(");
                dfs(new StringBuilder(s).deleteCharAt(i).toString(), i, l - 1, r);
            }
            if (r > 0 && s.charAt(i) == ')') {
                System.out.println("删除第" + (i + 1) + "个)");
                dfs(new StringBuilder(s).deleteCharAt(i).toString(), i, l, r - 1);
            }
        }
    }

    public boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    @Test
    public void test() {
        System.out.println(removeInvalidParentheses("(()("));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses(")d))"));
        System.out.println(removeInvalidParentheses("(()"));
    }
}
