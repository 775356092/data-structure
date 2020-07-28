import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class test {


    // 合法的子网掩码255.255.255.0
    // 二进制下前面全是1，后面全是0
    // 合法的子网掩码取反（000000001111111……）加一（00000001000000……）后应该只有一个1，即为2的n次方
    public static boolean isMask(String s) {
        String[] split = s.split("\\.");
        int m = 0;
        for (int i = 3; i >= 0; i--) {
            m += (Integer.parseInt(split[i]) << ((3 - i) * 8));//左移8位
        }
        m = ~m + 1;//取反加一
        if ((m & (m - 1)) == 0) {//如果二进制数中只有一个1，即为2^n
            return true;
        }
        return false;
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     *
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        System.out.println(2%-3);
    }
}
