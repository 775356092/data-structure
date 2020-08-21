package LeetCode;

public class _151 {
    //151.翻转字符串里的单词
    //给定一个字符串，逐个翻转字符串中的每个单词。
    public static String reverseWord(String s){
        StringBuilder sb = new StringBuilder();
        s.trim();//去前后空格
        String[] split = s.split("\\s+");//分割一个或多个空格
        for(int i= split.length-1;i>=0;i--){
            if(i==0){
                sb.append(split[i]);
            }else {
                sb.append(split[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = reverseWord(" I am  a teacher ");
        System.out.println(res);
    }
}
