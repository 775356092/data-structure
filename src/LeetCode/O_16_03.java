package LeetCode;

import java.util.Arrays;

public class O_16_03 {
    //面试题 16.03. 交点
    //给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
    //
    //要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double x1 = start1[0];
        double y1 = start1[1];
        double x2 = end1[0];
        double y2 = end1[1];
        double x3 = start2[0];
        double y3 = start2[1];
        double x4 = end2[0];
        double y4 = end2[1];
        double x = 0;
        double y = 0;

        double k1 = (y2 - y1) / (x2 - x1);
        double k2 = (y4 - y3) / (x4 - x3);
        double[] res = new double[2];
        if (x1 != x2 && x3 != x4) {
            if (k1 == k2) {
                //同一条直线返回最小x
                if ((y1 - x1 * k1) == (y3 - x3 * k2)) {
                    if(Math.max(x3,x4)>=Math.max(x1,x2)){
                        if(Math.max(x1,x2)>=Math.min(x3,x4)){
                            x = Math.max(Math.min(x1, x2), Math.min(x3, x4));
                            y = k1 * (x - x1) + y1;
                            res[0] = x;
                            res[1] = y;
                            return res;
                        }else {
                            return new double[0];
                        }
                    }else if(Math.max(x1,x2)>=Math.max(x3,x4)){
                        if(Math.max(x3,x4)>=Math.min(x1,x2)){
                            x = Math.max(Math.min(x1, x2), Math.min(x3, x4));
                            y = k1 * (x - x1) + y1;
                            res[0] = x;
                            res[1] = y;
                            return res;
                        }else {
                            return new double[0];
                        }
                    }

                } else {
                    return new double[0];
                }
            }

            x = (k1 * x1 - k2 * x3 + y3 - y1) / (k1 - k2);
            if (Math.min(x1, x2) <= x && x <= Math.max(x1, x2) && Math.min(x3, x4) <= x && x <= Math.max(x3, x4)) {
                y = k1 * (x - x1) + y1;
                res[0] = x;
                res[1] = y;
                return res;
            } else {
                return new double[0];
            }
        } else if (x1 == x2 && x3 != x4) {
            if (x1 >= Math.min(x3, x4) && x1 <= Math.max(x3, x4)) {
                x = x1;
                res[0] = x;
                res[1] = (x - x3) * k2 + y3;
                return res;
            } else {
                return new double[0];
            }
        } else if (x1 != x2 && x3 == x4) {
            if (x3 >= Math.min(x1, x2) && x3 <= Math.min(x1, x2)) {
                x = x3;
                res[0] = x;
                res[1] = k1 * (x - x1) + y1;
                return res;
            } else {
                return new double[0];
            }
        } else if (x1 == x2 & x3 == x4) {
            if (x1 == x3) {
                if (Math.max(y3, y4) >= Math.max(y1, y2)) {
                    if (Math.max(y1, y2) >= Math.min(y3, y4)) {
                        x = x1;
                        res[0] = x;
                        y = Math.max(Math.min(y1, y2), Math.min(y2, y3));
                        res[1] = y;
                        return res;
                    } else {
                        return new double[0];
                    }
                } else if (Math.max(y1, y2) >= Math.max(y3, y4)) {
                    if (Math.max(y3, y4) >= Math.min(y1, y2)) {
                        x = x1;
                        res[0] = x;
                        y = Math.max(Math.min(y1, y2), Math.min(y2, y3));
                        res[1] = y;
                        return res;
                    } else {
                        return new double[0];
                    }
                }
            } else {
                return new double[0];
            }

        } else {
            return new double[0];
        }

        return new double[0];
}

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 1}, new int[]{-1, 1}, new int[]{1, 0}, new int[]{-3, 2})));
    }
}
