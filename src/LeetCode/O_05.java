package LeetCode;

public class O_05 {
    //面试题05. 替换空格
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==' '){
                sb.replace(i,i+1,"%");
                sb.insert(i+1,"20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = replaceSpace("I AM A TEACHER");
        System.out.println(s);
    }
}
