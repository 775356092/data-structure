package LeeCode;

public class _14 {
    //14. 最长公共前缀
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        if(strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            boolean flag = true;
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length()){
                    flag = false;
                    break;
                }
                if(i<strs[j].length()&&strs[j].charAt(i)!=c){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(c);
            }else {
                break;
            }
        }
        if(sb.length()>0){
            return sb.toString();
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca","cba"}));
    }
}
