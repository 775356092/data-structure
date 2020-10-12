package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 复原IP地址
 * @author: wang hao
 * @create: 2020-10-12 14:00
 */
public class _93 {

    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(String s, ArrayList<String> path, int start) {
        if (path.size() == 4 && start != s.length()) return;
        if (path.size() == 4) {
            res.add(path.get(0) + "." + path.get(1) + "." + path.get(2) + "." + path.get(3));
            return;
        }
        for (int len = 1; len <= 3; len++) {
            // 不能越界
            if (len + start > s.length()) break;
            // 不能以0开头
            if (len > 1 && s.charAt(start) == '0') break;
            String t = s.substring(start, start + len);
            int n = Integer.parseInt(t);
            if (n < 256) {
                path.add(t);
                dfs(s, path, start + len);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("19216811"));
    }
}
