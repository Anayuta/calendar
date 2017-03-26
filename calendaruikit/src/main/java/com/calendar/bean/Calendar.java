package com.calendar.bean;

import java.io.Serializable;

/**
 * Created by nayuta on 17-3-26.
 */

public class Calendar implements Serializable{

    private int year;
    private int month;
    private int day;
    private boolean currentMonth;
    private boolean isCurrentDay;
    private boolean selected;
    private String lunar;//农历
    private String scheme;//计划，可以用来标记当天是否有任务

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(boolean currentMonth) {
        this.currentMonth = currentMonth;
    }

    public boolean isCurrentDay() {
        return isCurrentDay;
    }

    public void setCurrentDay(boolean currentDay) {
        isCurrentDay = currentDay;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
