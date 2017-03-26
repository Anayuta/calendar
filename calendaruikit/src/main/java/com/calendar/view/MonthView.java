package com.calendar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.calendar.bean.Calendar;
import com.view.calendaruikit.R;

import java.util.List;

/**
 * Created by nayuta on 17-3-26.
 * 月份卡
 */

public class MonthView extends View {

    private int mDiff;//第一天偏移周日多少天
    private int mCount;//总数
    private int mLastCount;//最后一行的天数
    private int mLine;//多少行

    private Paint mPaint = new Paint();
    private Paint mSchemePaint = new Paint();

    private List<Calendar> mSchemes;
    private Calendar mCalendar;

    public MonthView(Context context) {
        this(context, null);
    }

    public MonthView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mSchemePaint.setAntiAlias(true);
        mSchemePaint.setTextAlign(Paint.Align.CENTER);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MonthView);
        mPaint.setTextSize(array.getDimensionPixelSize(R.styleable.MonthView_month_view_text_size, 12));
        mSchemePaint.setTextSize(array.getDimensionPixelSize(R.styleable.MonthView_month_view_text_size, 12));

        mPaint.setColor(array.getColor(R.styleable.MonthView_month_view_text_color, Color.BLACK));
        mSchemePaint.setColor(array.getColor(R.styleable.MonthView_month_view_remark_color, Color.RED));

        array.recycle();

        measureLine();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        int pLeft = getPaddingLeft();
        int w = (width - getPaddingLeft() - getPaddingRight()) / 7;//每个item的宽
        int h = (height - getPaddingTop() - getPaddingBottom()) / 6;//每个item的高

        int d = 0;
        //行
        for (int i = 0; i < mLine; i++) {
            if (i == 0) {//第一行
                for (int j = 0; j < (7 - mDiff); j++) {
                    ++d;
                    //每个月1号开始，j+1.
                    canvas.drawText(String.valueOf(j + 1), mDiff * w + j * w + pLeft + w / 2, h, isScheme(d) ? mSchemePaint : mPaint);
                }
            } else if (i == mLine - 1 && mLastCount != 0) {
                int first = mCount - mLastCount + 1;
                for (int j = 0; j < mLastCount; j++) {
                    ++d;
                    canvas.drawText(String.valueOf(first), j * w + pLeft + w / 2, (i + 1) * h, isScheme(d) ? mSchemePaint : mPaint);
                    ++first;
                }
            } else {
                int first = i * 7 - mDiff + 1;
                for (int j = 0; j < 7; j++) {
                    ++d;
                    canvas.drawText(String.valueOf(first), j * w + pLeft + w / 2, (i + 1) * h, isScheme(d) ? mSchemePaint : mPaint);
                    ++first;
                }
            }
        }
    }

    /**
     * 判断这天是否有计划事项
     * @param day
     * @return
     */
    private boolean isScheme(int day) {
        if (mSchemes == null || mSchemes.size() == 0)
            return false;
        mCalendar.setDay(day);
        return mSchemes.contains(mCalendar);
    }

    /**
     * 计算行数
     */
    private void measureLine() {
        int offSet = mCount - (7 - mDiff);//减去第一天出现偏移量的行
        mLine = 1 + (offSet % 7 == 0 ? 0 : 1) + offSet / 7;//
        mLastCount = offSet % 7;
    }

    /**
     * 初始化月份卡
     * @param mDiff
     * @param mCount
     * @param mYear
     * @param mMonth
     */
    public void init(int mDiff,int mCount,int mYear,int mMonth){
        this.mDiff = mDiff;
        this.mCount = mCount;
        mCalendar = new Calendar();
        mCalendar.setYear(mYear);
        mCalendar.setMonth(mMonth);
        measureLine();
        invalidate();
    }


    /**
     * 设置计划事项
     * @param mSchemes
     */
    public void setSchemes(List<Calendar> mSchemes){
        this.mSchemes = mSchemes;
    }

    public void setSchemeColor(int schemeColor){
        if (schemeColor!=0){
            mSchemePaint.setColor(schemeColor);
        }
        if (schemeColor==0xff30393E){
            mSchemePaint.setColor(Color.RED);
        }
    }


}
