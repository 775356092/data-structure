package Char;

import java.util.HashSet;
import java.util.Scanner;

public class No_Repeat_Char {
    // 统计一个字符串中不同字符的数量
    // 输入 abcccddddeeeeffff
    // 输出 6
    public static void m(String s){
        char[] c = s.toCharArray();
        HashSet set = new HashSet<>();
        for (char ch:c){
            set.add(ch);
        }
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        m(s);
    }
}
