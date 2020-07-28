package LeeCode;

public class _507 {
    //507. 完美数
    //对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
    //给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
    public boolean checkPerfectNumber(int num) {
        if(num==0){
            return false;
        }
        if(num%2!=0){//奇数
            return false;
        }
        int sum=0;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                sum+=i;
                if(i*i<=num){
                    sum+=num/i;
                }
            }
        }
        return sum==2*num?true:false;
    }
}
