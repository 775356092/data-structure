package String;

import java.util.*;

public class Brother_Word {

    //查找兄弟单词 abc acb cba
    //字母顺序不同
    public static boolean m(String s1,String s2){
        if(s1.equals(s2)||s1.length()!=s2.length()){
            return false;
        }
        char[] s3 = s1.toCharArray();
        char[] s4 = s2.toCharArray();
        Arrays.sort(s3);
        Arrays.sort(s4);
        return Arrays.equals(s3,s4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int l = s.length;
            int m = Integer.parseInt(s[l - 1]);
            String s1 = s[l - 2];
            ArrayList<String> list = new ArrayList<>();
            int res = 0;
            for (int i = 1; i < l - 2; i++) {
                String s2 = s[i];
                if (m(s1, s2)) {
                    res++;
                    list.add(s2);
                }
            }
            Collections.sort(list);
            if (list.size() == 0) {
                System.out.println(0);
            } else if (m > res) {
                System.out.println(res);
            } else {
                System.out.println(res);
                System.out.println(list.get(m - 1));
            }

        }
    }
}
