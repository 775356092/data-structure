import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = Integer.parseInt(scanner.nextLine());
            if(a==0){
                System.out.println("end");
            }else {
                System.out.println(m(a));
            }
        }*/
        System.out.println(m(4));
    }

    public static int m(int num){
        int count = 0;
        for(int i=2;i<=num/2;i++){
            if(isPrime(i)&&isPrime(num-i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num){
        boolean flag = true;
        if(num<2){
            return false;
        }else {
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
