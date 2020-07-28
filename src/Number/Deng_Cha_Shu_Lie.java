package Number;

import java.util.Scanner;

public class Deng_Cha_Shu_Lie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            int a1 = 2;
            int d = 3;
            System.out.println(n*(a1+a1+(n-1)*d)/2);
        }

    }
}
