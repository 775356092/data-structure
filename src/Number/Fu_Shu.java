package Number;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Fu_Shu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] string = in.nextLine().split(" ");
            int count = 0;     //负数个数
            double sum = 0;    //非负数和
            for (int i = 0; i <= string.length-1; i++){
                int num = Integer.parseInt(string[i]);
                if (num < 0){
                    count++;
                }else {
                    sum += num;
                }
            }
            System.out.println(count);
            //保留一位小数
            DecimalFormat decimalFormat = new DecimalFormat(".#");
            if(count == string.length){
                //非负数为0的情况
                System.out.print("0.0");
            }else {
                System.out.print(
                        decimalFormat.format(sum/(string.length-count)));
            }
        }
    }
}
