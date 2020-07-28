package LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class O_38 {

    static Set<String> res=new HashSet<>();//排重
    public static String[] m(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        String s = sb.toString();
        if(s==null)return new String[]{};//空
        boolean[] visited=new boolean[s.length()];
        dfs(s,"",visited);
        String[] result=new String[res.size()];
        return res.toArray(result);
    }

    private static void dfs(String s,String letter,boolean[] visited){
        if(s.length()==letter.length()){
            res.add(letter);
            return ;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(visited[i])continue;
            visited[i]=true;
            dfs(s,letter+c,visited);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        String[] m = m(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(m));
    }
}
