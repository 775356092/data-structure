package LeetCode;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-08-27 16:49
 */
public class _1528 {
    public static String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            sb.replace(indices[i], indices[i] + 1, String.valueOf(s.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3});
        System.out.println(string);
    }
}
