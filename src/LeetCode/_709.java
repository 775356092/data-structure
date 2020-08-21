package LeetCode;

public class _709 {
    //709. 转换成小写字母
    //实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                sb.replace(i,i+1,(char)(str.charAt(i)+32)+"");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("LoVeLy"));
    }
}
