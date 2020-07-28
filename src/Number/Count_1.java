package Number;

import java.util.Scanner;

public class Count_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int res = 0;
            for(int i=31;i>=0;i--){
                if((a>>>i&1)==1){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
