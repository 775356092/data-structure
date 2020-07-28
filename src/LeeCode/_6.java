package LeeCode;

/**
 * @description: Z 字形变换
 * @author: wang hao
 * @create: 2020-07-17 10:20
 */
public class _6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     */

    /**
     * 字符串按顺序走
     * [0,0] -> [1,0] -> [2,0] -> ... ->[numRows,0] -> [numRows-1,1] -> [nuRows-2,2] -> ... ->
     * [0,x] -> [1,x] -> [2,x] -> ... ->[numRows,x] -> [numRows-1,x+1] -> [numRows-2,x+2] -> ... ->
     * [0,y] -> ...
     */
    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return null;
        }
        if (numRows == 1 || numRows == 2) {
            return s;
        }
        /**
         * numRows-2+numRows个字符占numRows-1列
         */
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int row = len / numRows + 1;
        char[][] arr = new char[numRows][];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < row; j++) {

            }
        }
        return null;
    }
}
