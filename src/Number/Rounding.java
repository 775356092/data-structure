package Number;

import java.util.Scanner;

public class Rounding {

    //四舍五入
    public static void round(Double d){
        System.out.println(Math.round(d));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Double d = scanner.nextDouble();
            round(d);
        }
    }
}
