package LeeCode;

public class _1221 {
    //1221. 分割平衡字符串
    //在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
    //给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
    //返回可以通过分割得到的平衡字符串的最大数量。
    public int balancedStringSplit(String s) {
        if(s.length()==0){
            return 0;
        }
        int balance=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                balance--;
            }
            if(s.charAt(i)=='R'){
                balance++;
            }
            if(balance==0){
                res++;
            }
        }
        if(res==0){
            return 1;
        }
        return res;
    }
}
