package datastructure;

import java.util.Scanner;

public class PerCalender {
    public static void main(String[] args) {
        //输入初始日期
        Scanner s1 = new Scanner(System.in);
        System.out.println("请输入初始日期(yyyy-MM-dd)：");
        String StartDate = s1.nextLine();
        //输入截止日期
        Scanner s2 = new Scanner(System.in);
        System.out.println("请输入截止日期(yyyy-MM-dd)：");
        String EndDate = s2.nextLine();

        PerCalender a = new PerCalender();
        String result = a.NumberOfDays(StartDate,EndDate);
//		System.out.println("初始日期到截止日期之间经过了 " + days + " 天！");
        System.out.println(result);
    }

    /**
     * 求初始日期到截止日期之间的天数
     *
     * @param s1
     * 		初始日期
     * @param s2
     * 		截止日期
     */
    public String NumberOfDays(String s1,String s2){
        int MonthDays[][] = new int[][]{{1,2,3,4,5,6,7,8,9,10,11,12},{31,28,31,30,31,30,31,31,30,31,30,31}};

        //解析初始日期年、月、日
        int year1 = Integer.parseInt(s1.substring(0, s1.indexOf("-")));
        int month1 = Integer.parseInt(s1.substring(s1.indexOf("-")+1,s1.lastIndexOf("-")));
        int day1 = Integer.parseInt(s1.substring(s1.lastIndexOf("-")+1,s1.length()));

        //解析截止日期年、月、日
        int year2 = Integer.parseInt(s2.substring(0, s2.indexOf("-")));
        int month2 = Integer.parseInt(s2.substring(s2.indexOf("-")+1,s2.lastIndexOf("-")));
        int day2 = Integer.parseInt(s2.substring(s2.lastIndexOf("-")+1,s2.length()));

        //获取闰年个数
        int NumberOfLeapYears = 0;
        for (int i = (year1 + 1);i < year2;i++){
            if(IsLeapYear(i))
                NumberOfLeapYears++;
        }

        //初始日期到截止日期的整年数
        int years = year2 - year1 - 1;

        //初始日期这一年剩余的天数

        int daysOfSurplusYear1 = MonthDays[1][month1 - 1] - day1 + 1;

        if(IsLeapYear(year1)){
            if(month1 <= 2)
                daysOfSurplusYear1++;
        }
        for(int i = (month1 + 1);i < 13;i++){
            daysOfSurplusYear1 += MonthDays[1][i - 1];
        }
        //截止日期这一年过去的天数
        int daysOfPassYear2 = day2;
        if(IsLeapYear(year2)){
            if((month2 > 2) || ((month2 == 2) && (day2 == 29)))
                daysOfPassYear2++;
        }
        for(int i = (month2 - 1);i > 0;i--){
            daysOfPassYear2 += MonthDays[1][i - 1];
        }

        return "初始日期到截止日期之间经过了 " + (365 * years + daysOfSurplusYear1 + daysOfPassYear2 + NumberOfLeapYears) + " 天！" ;
    }

    /**
     * 判断是否是闰年
     *
     * @param year
     * 		输入的年份
     */
    public boolean IsLeapYear(int year){
        boolean isLeapYear=false;
        if((year % 4) == 0){
            if((year % 100) == 0){
                if((year %400) == 0)
                    isLeapYear=true;
                return false;
            }
            isLeapYear=true;
        }
        return isLeapYear;
    }

}