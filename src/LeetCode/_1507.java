package LeetCode;

/**
 * @description: 转变日期格式
 * @author: wang hao
 * @create: 2020-08-27 17:03
 */
public class _1507 {
    //"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"

    public static String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] split = date.split(" ");
        String year = split[2];
        String month = split[1];
        if (month.equals("Jan")) {
            month = "01";
        } else if (month.equals("Feb")) {
            month = "02";
        } else if (month.equals("Mar")) {
            month = "03";
        } else if (month.equals("Apr")) {
            month = "04";
        } else if (month.equals("May")) {
            month = "05";
        } else if (month.equals("Jun")) {
            month = "06";
        } else if (month.equals("Jul")) {
            month = "07";
        } else if (month.equals("Aug")) {
            month = "08";
        } else if (month.equals("Sep")) {
            month = "09";
        } else if (month.equals("Oct")) {
            month = "10";
        } else if (month.equals("Nov")) {
            month = "11";
        } else if (month.equals("Dec")) {
            month = "12";
        }
        String day = split[0];
        day = day.substring(0, day.length() - 2);
        sb.append(year);
        sb.append("-");
        sb.append(month);
        sb.append("-");
        sb.append(day);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = reformatDate("26th May 1960");
        System.out.println(s);
    }
}
