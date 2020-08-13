package LeeCode;

/**
 * @description: 字符串相乘
 * @author: wang hao
 * @create: 2020-08-13 10:10
 */
public class _43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for (int j = num2.length() - 1; j >= 0; j--) {
            int y = num2.charAt(j) - '0';
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            //增加0
            for (int k = 0; k < num2.length() - j - 1; k++) {
                temp.append("0");
            }
            for (int i = num1.length() - 1; i >= 0 || carry != 0; i--) {
                int x = i < 0 ? 0 : num1.charAt(i) - '0';
                int mul = (x * y + carry) % 10;
                temp.append(mul);
                carry = (x * y + carry) / 10;
            }
            res = addString(res, temp.reverse().toString()).toString();
        }
        return res;
    }

    //字符串相加
    public String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
