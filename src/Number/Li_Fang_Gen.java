package Number;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Li_Fang_Gen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double a = scanner.nextDouble();
            DecimalFormat df=new DecimalFormat("0.0");
            System.out.println(df.format(Math.pow(a,1.0/3.0)));
        }
    }
}
