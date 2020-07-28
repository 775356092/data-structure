package String;

import java.util.Scanner;

public class Count_Uppercase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int res=0;
            for(int i=0;i<s.length();i++){
                if(Character.isUpperCase(s.charAt(i))){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
