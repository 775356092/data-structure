package LeetCode;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Description : 拆分字符串使唯一子字符串的数目最大
 * @Author : wang hao
 * @Date: 2020-09-20 10:52
 */
public class _5520 {

    HashSet<String> set = new HashSet<>();
    int res = 1;

    public int maxUniqueSplit(String s) {
        int res = 0;
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int index) {
        if (index == s.length()) {
            res = Math.max(set.size(), res);
            return;
        }
        for (int i = index + 1; i < s.length(); i++) {
            String t = s.substring(index, i);
            if (set.contains(t)) {
                continue;
            }
            set.add(t);
            dfs(s, i + 1);
        }
    }


    @Test
    public void test() {
        System.out.println(maxUniqueSplit("addbsd"));
        /*System.out.println(maxUniqueSplit("aba"));
        System.out.println(maxUniqueSplit("aa"));*/
    }


}
