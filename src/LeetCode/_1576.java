package LeetCode;

import org.junit.Test;

/**
 * @description: 替换所有问号
 * @author: wang hao
 * @create: 2020-09-11 15:41
 */
public class _1576 {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                char pre = i == 0 ? ' ' : arr[i - 1];
                char next = i == s.length() - 1 ? ' ' : arr[i + 1];
                char temp = 'a';
                while (pre == temp || next == temp) {
                    temp++;
                }
                arr[i] = temp;
            }
        }
        return new String(arr);
    }

    @Test
    public void test() {
        System.out.println(modifyString("?zs"));
    }
}
