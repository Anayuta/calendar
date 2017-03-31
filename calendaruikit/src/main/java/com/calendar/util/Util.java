package com.calendar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nayuta on 17-3-30.
 *
 * 格式化数据
 */

public class Util {

    static int getDate(String formatText, Date date){
        SimpleDateFormat format = new SimpleDateFormat(formatText);
        return Integer.parseInt(format.format(date));
    }


    /**
     * 获取这个月的总天数
     * @param year
     * @param month
     * @return
     */
    static int getMonthDaysCount(int year,int month){
        int count=0;//当月的天数
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,1);
        //大月
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            count=31;
        }
        //小月
        if (month==4||month==6||month==9||month==11){
            count=30;
        }
        //判断平年或是闰年
        if (month==2){
            if (((month%4==0)&&(month%100!=0))||(month%400==0)){
                count=29;
            }else {
                count=28;
            }
        }
        return count;
    }


}
