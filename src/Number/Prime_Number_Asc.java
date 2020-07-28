package Number;

import java.util.Scanner;

public class Prime_Number_Asc {

    // 输入一个正整数，从小到大输出所有的质因子

    public static String getResult(long ulDataInput){
        StringBuilder stringBuilder = new StringBuilder();
        int a = (int) Math.sqrt(ulDataInput)+1;
        int i = 2;
        while (i<=a&&ulDataInput!=1){
            if(ulDataInput%i==0){
                stringBuilder.append(String.valueOf(i)+" ");
                ulDataInput/=i;
                i=2;
            }else {
                i++;
            }
            if(i>a){
                stringBuilder.append(String.valueOf(ulDataInput)+" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long l = scanner.nextLong();
            System.out.println(getResult(l));
        }
    }
}
