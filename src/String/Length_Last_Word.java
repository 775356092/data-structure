package String;

import java.util.Scanner;

public class Length_Last_Word {
    // 计算字符串最后一个单词的长度，单词以空格隔开。
    // 输入hello world
    // 输出5
    public static void length(String s){
        String[] s1 = s.split(" ");
        int index = s1.length-1;
        System.out.println(s1[index].toCharArray().length);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        length(s);
    }
}
