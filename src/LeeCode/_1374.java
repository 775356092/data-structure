package LeeCode;

/**
 * @program: data-structure
 * @description: 生成每种字符都是奇数个的字符串
 * @author: wang hao
 * @create: 2020-05-18 13:00
 */
public class _1374 {
    /**
     * 给你一个整数 n，1请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     * <p>
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
     */
    public static String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                res.append("a");
            }
            res.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                res.append("a");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(2));
    }
}
