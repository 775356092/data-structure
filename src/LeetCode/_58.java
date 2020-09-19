package LeetCode;

/**
 * @description: 最后一个单词的长度
 * @author: wang hao
 * @create: 2020-09-15 10:32
 */
public class _58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arr = s.trim().split("\\s+");
        return arr[arr.length - 1].length();
    }
}
