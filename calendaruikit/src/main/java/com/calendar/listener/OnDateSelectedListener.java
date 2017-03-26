package com.calendar.listener;

/**
 * Created by nayuta on 17-3-26.
 */

public interface OnDateSelectedListener {

    /**
     * 当天给选中
     * @param year
     * @param month
     * @param day
     * @param lunar
     * @param scheme
     */
    void onDateSelected(int year,int month,int day,String lunar,String scheme);

}
