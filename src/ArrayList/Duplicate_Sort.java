package ArrayList;

import java.util.*;

public class Duplicate_Sort {
    // 去重 排序
    // 输入多行，先输入随机整数的个数，再输入相应个数的整数
    public static void d_s(List arr){
        ArrayList<Integer> list = new ArrayList<>(new HashSet<Integer>(arr));
        Collections.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            List<Integer> arr = new ArrayList(num);
            for (int i = 0;i<num;i++){
                Integer a = scanner.nextInt();
                arr.add(a);
            }
            d_s(arr);
        }
    }
}
