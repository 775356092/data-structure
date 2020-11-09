package LeetCode;

import org.junit.Test;

/**
 * @Description : 重新排列单词间的空格
 * @Author : wang hao
 * @Date: 2020-09-20 10:38
 */
public class _5519 {
    public String reorderSpaces(String text) {
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                cnt++;
            }
        }
        if (cnt == 0) {
            return text;
        }
        String[] arr = text.trim().split("\\s+");
        if (arr.length == 1) {
            return new StringBuilder().append(arr[0]).append(" ".repeat(cnt)).toString();
        }
        int t = cnt / (arr.length - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if (i != arr.length - 1) {
                res.append(" ".repeat(t));
            }
        }
        if (cnt > 0) {
            res.append(" ".repeat(cnt - t * (arr.length - 1)));
        }
        return res.toString();
    }

    @Test
    public void test() {
        /*System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));*/
        System.out.println(reorderSpaces("  hello"));
    }
}
