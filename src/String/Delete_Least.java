package String;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;
import java.util.Scanner;

public class Delete_Least {

    //删除字符串中出现次数最少的字符后的字符串。
    //wfcziggscmglmwoooo
    public static void m(String s) {
        HashSet<Object> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int[] a = new int[26];
        for (int i = 0; i < c.length; i++) {
            a[c[i] - 97]++;
        }
        int min = 999;
        for (int i : a) {
            if (i != 0 && i < min) {
                min = i;
            }
        }
        for (int j = 0; j < a.length; j++) {
            if (a[j] != min && a[j] != 0) {
                char t = (char)(j+97);
                set.add(t);
            }
        }
        for (int j=0;j<c.length;j++){
            if(set.contains(c[j])){
                sb.append(c[j]);
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            while (s.isEmpty()) {
                break;
            }
            m(s);
        }
    }
}
