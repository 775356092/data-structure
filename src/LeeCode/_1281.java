package LeeCode;

public class _1281 {
    //1281. 整数的各位积和之差
    //给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
    public int subtractProductAndSum(int n) {
        int m=n;
        long product=1;
        long sum=0;
        while (m!=0){
            product*=m%10;
            m/=10;
        }
        while (n!=0){
            sum+=m%10;
            n/=10;
        }
        return (int) (product-sum);
    }

}
