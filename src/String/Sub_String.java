package String;

import java.util.Scanner;

public class Sub_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            boolean flag = true;
            for(int i=0;i<s1.length();i++){
                if(!s2.contains(s1.charAt(i)+"")){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(flag);
            }else {
                System.out.println(flag);
            }
        }
    }
}
