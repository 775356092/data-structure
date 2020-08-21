package LeetCode;

public class _1154 {
    //1154. 一年中的第几天
    //给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
    //通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
    public static int dayOfYear(String date) {
        int res=0;
        String[] split = date.split("-");
        String year = split[0];
        String month = split[1];
        String days = split[2];
        int day = 0;
        if(days.charAt(0)=='0'){
            day = Integer.parseInt(days.substring(1,2));
        }else {
            day = Integer.parseInt(days);
        }
        if(!isLeapYear(year)){//不是闰年
            switch (month){
                case "01":res+=day;break;
                case "02":res+=31;res+=day;break;
                case "03":res+=31;res+=28;res+=day;break;
                case "04":res+=31;res+=28;res+=31;res+=day;break;
                case "05":res+=31;res+=28;res+=31;res+=30;res+=day;break;
                case "06":res+=31;res+=28;res+=31;res+=30;res+=31;res+=day;break;
                case "07":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=day;break;
                case "08":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=31;res+=day;break;
                case "09":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=day;break;
                case "10":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=day;break;
                case "11":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=31;res+=day;break;
                case "12":res+=31;res+=28;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=31;res+=day;res+=30;break;
            }
        }else {
            switch (month){
                case "01":res+=day;break;
                case "02":res+=31;res+=day;break;
                case "03":res+=31;res+=29;res+=day;break;
                case "04":res+=31;res+=29;res+=31;res+=day;break;
                case "05":res+=31;res+=29;res+=31;res+=30;res+=day;break;
                case "06":res+=31;res+=29;res+=31;res+=30;res+=31;res+=day;break;
                case "07":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=day;break;
                case "08":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=31;res+=day;break;
                case "09":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=day;break;
                case "10":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=day;break;
                case "11":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=31;res+=day;break;
                case "12":res+=31;res+=29;res+=31;res+=30;res+=31;res+=30;res+=31;res+=31;res+=30;res+=31;res+=day;res+=30;break;
            }
        }

        return res;
    }

    //是否为闰年
    public static boolean isLeapYear(String year){
        int n = Integer.parseInt(year);
        if(n%4==0&&n%100!=0){//能被4整除但是不能被100整除
            return true;
        }else if(n%400==0){//能被400整除
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(dayOfYear("2004-03-01"));
    }
}
