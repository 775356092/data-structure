package LeeCode;

/**
 * @program: data-structure
 * @description: 反转字符串
 * @author: wang hao
 * @create: 2020-05-15 16:35
 */
public class _344 {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length /2; i++, j--) {
            if(s[i]!=s[j]){
                char c = s[i];
                s[i] = s[j];
                s[j] = c;
            }
        }
    }
}
