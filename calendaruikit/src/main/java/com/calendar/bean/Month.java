package com.calendar.bean;

import java.io.Serializable;

/**
 * Created by nayuta on 17-3-30.
 */

public class Month implements Serializable {

    private int diff;//第一天偏移的天数
    private int count;//当月总天数
    private int month;
    private int year;

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
