package com.calendar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.calendar.bean.Calendar;
import com.calendar.listener.OnDateChangeListener;
import com.calendar.listener.OnDateSelectedListener;
import com.view.calendaruikit.R;

import java.util.List;

/**
 * Created by nayuta on 17-3-31.
 *
 * 日历
 */

public class CalendarView extends FrameLayout{

    private ViewPager mViewPager;
    private List<Calendar> mSchemeDate;
    private OnDateChangeListener mListener;
    private OnDateSelectedListener mDateSelectedListener;
//    private OnInnerDate
//    private Sele


    public CalendarView(@NonNull Context context) {
        this(context,null);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CalendarView);
    }
}
