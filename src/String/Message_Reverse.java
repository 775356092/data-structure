package String;

import java.util.Scanner;

public class Message_Reverse {

    // 以英文单词为单位反转一个句子
    // 输入 I am a boy
    // 输出 boy a am I
    private static void m(String x) {
        StringBuilder sb = new StringBuilder();
        String s = x.trim();
        String[] s1 = s.split("\\s+");
        for(int i = s1.length-1;i>=0;i--){
            if(i==0){
                sb.append(s1[i]);
            }else {
                sb.append(s1[i]+" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder(s);
            for(int i=0;i<sb.length();i++){
                if(!Character.isLetter(sb.charAt(i))){
                    sb.replace(i,i+1," ");
                }
            }
            m(sb.toString());
        }

    }

}
