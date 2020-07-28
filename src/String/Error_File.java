package String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Error_File {

    public static HashMap<String,Integer> map = new LinkedHashMap();

    public static void m(String s){
        String[] s1 = s.split(" ");//分割多个空格
        String[] file = s1[0].split("\\\\");//分割反斜杠
        String name = file[file.length-1];
        if(name.length()>16){
            name = name.substring(name.length()-16);//截取后16位文件名
        }
        String place = s1[1];
        String error = name+" "+place;
        if(map.containsKey(error)){
            map.put(error,map.get(error)+1);
        }else {
            map.put(error,1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.isEmpty()){
                break;
            }
            m(s);
        }
        Set set = map.keySet();
        int n=0;
        for(Object o:set){
            n++;
            if(n>(set.size()-8)){
                System.out.println(o+" "+map.get(o));
            }
        }
    }
}
