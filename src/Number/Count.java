package Number;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            long a =0;//正数个数
            int b = 0;//负数个数
            long sum = 0;
            for (int i=0;i<n;i++){
                int x = scanner.nextInt();
                if(x<0){
                    b++;
                }else if(x>0) {
                    a++;
                    sum+=x;
                }
            }
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println(b+" "+df.format((double) sum/a));
        }
    }
}
