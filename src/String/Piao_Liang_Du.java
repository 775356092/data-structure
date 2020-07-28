package String;

import java.util.Scanner;

public class Piao_Liang_Du {

    //给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
    //每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
    public static void m(String s){
        int[] c = new int[200];
        for (int i=0;i<s.length();i++){
            c[s.charAt(i)]++;
        }
        int max = 0;
        for(int i=0;i<c.length;i++){
            if(max<c[i]){
                max = c[i];
            }
        }
        int x = 26;
        int res = 0;
        for(;max>=0;max--){
            for(int j=0;j<c.length;j++){
                if(c[j]==max){
                    res+=max*x;
                    x--;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            for(int i = 0;i<n;i++){
                String s = scanner.nextLine();
                m(s);
            }
        }
    }
}
