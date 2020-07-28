package String;

import java.util.Scanner;

public class Disk_Size {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextLine();
            }
            for(int i=0;i<n-1;i++){//冒泡排序
                for(int j=n-1;j>i;j--){
                    String s = arr[j];
                    String s1 = arr[j-1];
                    int a=0;
                    int b=0;
                    if(s.charAt(s.length()-1)=='t'||s.charAt(s.length()-1)=='T'){
                        a = Integer.parseInt(s.substring(0,s.length()-1))*1000*1000;
                    }else if(s.charAt(s.length()-1)=='G'||s.charAt(s.length()-1)=='g'){
                        a = Integer.parseInt(s.substring(0,s.length()-1))*1000;
                    }else if(s.charAt(s.length()-1)=='m'||s.charAt(s.length()-1)=='M'){
                        a = Integer.parseInt(s.substring(0,s.length()-1));
                    }
                    if(s1.charAt(s1.length()-1)=='t'||s1.charAt(s1.length()-1)=='T'){
                        b = Integer.parseInt(s1.substring(0,s1.length()-1))*1000*1000;
                    }else if(s1.charAt(s1.length()-1)=='G'||s1.charAt(s1.length()-1)=='g'){
                        b = Integer.parseInt(s1.substring(0,s1.length()-1))*1000;
                    }else if(s1.charAt(s1.length()-1)=='m'||s1.charAt(s1.length()-1)=='M'){
                        b = Integer.parseInt(s1.substring(0,s1.length()-1));
                    }
                    if(b>a){
                        String temp  = arr[j];
                        arr[j] =arr[j-1];
                        arr[j-1]=temp;
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
