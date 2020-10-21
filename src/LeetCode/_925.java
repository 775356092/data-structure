package LeetCode;

import org.junit.Test;

/**
 * @description: 长按键入
 * @author: wang hao
 * @create: 2020-10-21 09:05
 */
public class _925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    @Test
    public void test(){
        System.out.println(isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName("vtkgn","vttkgnn"));
    }
}
