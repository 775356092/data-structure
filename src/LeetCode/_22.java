package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * @author: wang hao
 * @create: 2020-08-14 09:50
 */
public class _22 {
    //左括号的个数大于右括号的个数 剪枝
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String str, int left, int right, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }
}
