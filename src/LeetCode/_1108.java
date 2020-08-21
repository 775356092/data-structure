package LeetCode;

public class _1108 {
    //1108. IP 地址无效化
    //给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
    //所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        int count = 0;
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.replace(i+count,i+count+1,"[.]");
                count+=2;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}
