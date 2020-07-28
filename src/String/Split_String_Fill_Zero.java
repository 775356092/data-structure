package String;

import java.util.Scanner;

public class Split_String_Fill_Zero {
    // 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
    // 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
    // 输入 abc
    //      123456789
    // 输出 abc00000
    //      12345678
    //      90000000
    public static void f_z(String s1) {
        if (s1 != "") {
            if (s1.length() <= 8) {
                while (s1.length() < 8) {
                    s1 += "0";
                }
                System.out.println(s1);
            } else {
                while (s1.length() > 8) {
                    System.out.println(s1.substring(0, 8));
                    s1 = s1.substring(8);
                }
                while (s1.length() < 8) {
                    s1 += "0";
                }
                System.out.println(s1);
            }
        } else {
            System.out.println(s1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                f_z(s);
            }

        }

    }
}
