package com.calendar.listener;

/**
 * Created by nayuta on 17-3-26.
 */

public interface OnDateChangeListener {

    /**
     * 日期改变
     * @param year
     * @param month
     * @param day
     * @param lunar
     * @param scheme
     */
    void onDateChange(int year,int month,int day,String lunar,String scheme);

    /**
     * 年改变
     * @param year
     */
    void onYearChange(int year);
}
