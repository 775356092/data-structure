package String;

import java.util.Scanner;

public class Bottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            if(n==0){
                break;
            }
            if(n==1){
                System.out.println(0);
            }else if(n==2){
                System.out.println(1);
            }else {
                System.out.println(n/2);
            }
        }
    }
}
