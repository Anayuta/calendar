package com.calendar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.view.calendaruikit.R;

/**
 * Created by nayuta on 17-3-26.
 *
 * 日历item
 */

public class CellView extends View{

    private int mDay = 20;//阳历
    private String mLunar;//阴历
    private String mScheme;

    private Paint mDayPaint = new Paint();//天
    private Paint mLunarPaint = new Paint();//阴历
    private Paint mSchemePaint = new Paint();//
    private Paint mCirclePaint = new Paint();//圆形角标

    private Paint mSelectedPaint = new Paint();//选中

    private int mRadius;//圆形角标的园角
    private int mCirclePadding;//圆形角标内部文字的padding
    private int mCircleColor;

    private boolean isSelectedDay;

    public CellView(Context context) {
        this(context,null);
    }

    public CellView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs,defStyleAttr);

    }

    /**
     * 初始化xml配置属性
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        initPaints();
        //初始化属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CellView);
        mDayPaint.setTextSize(array.getDimensionPixelSize(R.styleable.CellView_cell_day_text_size,18));
        mLunarPaint.setTextSize(array.getDimensionPixelSize(R.styleable.CellView_cell_lunar_text_size,12));
        mRadius = (int) array.getDimension(R.styleable.CellView_cell_scheme_radius,8);
        mSchemePaint.setTextSize(array.getDimensionPixelSize(R.styleable.CellView_cell_scheme_text_size,6));
        mCirclePadding = array.getDimensionPixelSize(R.styleable.CellView_cell_circle_padding_size,4);
        mCirclePaint.setColor(array.getColor(R.styleable.CellView_cell_circle_color,0xff16BB7F));

        array.recycle();

    }

    private void initPaints() {
        mDayPaint.setAntiAlias(true);//抗锯齿
        mDayPaint.setColor(Color.BLACK);//黑色
        mDayPaint.setFakeBoldText(true);
        mDayPaint.setTextAlign(Paint.Align.CENTER);//居中

        mLunarPaint.setAntiAlias(true);
        mLunarPaint.setColor(Color.GRAY);
        mLunarPaint.setTextAlign(Paint.Align.CENTER);

        mSelectedPaint.setAntiAlias(true);
        mSelectedPaint.setColor(0x50CFCFCF);
        mSelectedPaint.setStyle(Paint.Style.FILL);

        mSchemePaint.setAntiAlias(true);
        mSchemePaint.setColor(Color.WHITE);
        mSchemePaint.setFakeBoldText(true);
        mSchemePaint.setTextAlign(Paint.Align.CENTER);

        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.FILL);//填充
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int w = width-getPaddingLeft() -getPaddingRight();//宽度减去左右两边距
        int h = (height-getPaddingTop()-getPaddingBottom())/4;//去除顶部和底部，然后作为4份，因为还有一个阴历显示
        canvas.drawText(String.valueOf(mDay),w/2,2*h+getPaddingTop(),mDayPaint);
        canvas.drawText(mLunar,w/2,4*h+getPaddingTop(),mLunarPaint);
        //
        if (!TextUtils.isEmpty(mScheme)){
            //x:w/2为中间+阳历的字宽
            canvas.drawCircle(w/2+mCirclePadding+mDayPaint.getTextSize(),getPaddingTop()+h,mRadius,mCirclePaint);
            canvas.drawText(mScheme,w/2+mCirclePadding+mDayPaint.getTextSize(),getPaddingTop()+h+mRadius/2,mSchemePaint);
        }
    }

    public void init(int day,String lunar,String scheme){
        this.mDay = day;
        this.mLunar = lunar;
        this.mScheme = scheme;
        invalidate();
    }

    public void setTextColor(int color){
        mDayPaint.setColor(color);
        mLunarPaint.setColor(color);
        invalidate();
    }

    public void setCircleColor(int color){
        mCirclePaint.setColor(color);
        invalidate();
    }

    public void setSelectedColor(int color){
        this.mSelectedPaint.setColor(color);
    }

    public void setSelectedDay(boolean selectedDay){
        this.isSelectedDay = selectedDay;
    }



}
