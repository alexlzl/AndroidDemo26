package com.example.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @ Author： LiuZhouLiang
 * @ Time： 2022/3/30 9:56 上午
 * @ Description：
 */
public class ScrollLinearLayout extends LinearLayout {
    private static final String TAG="TAG";

    public ScrollLinearLayout(Context context) {
        super(context);
        init();
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;

    private void init() {
        mScroller = new Scroller(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        int x = (int) event.getX();
        Log.e(TAG,"init===x="+x+"init==y="+y);
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mLastY = y;
                mLastX = x;
                Log.e(TAG,"ACTION_DOWN==mlasty="+mLastY+"ACTION_DOWN==mlastx=="+mLastX);

                break;
            case MotionEvent.ACTION_MOVE:
                int dy = mLastY - y;//本次手势滑动了多大距离
                int dx = mLastX - x;
                Log.e(TAG,"ACTION_MOVE==dy="+dy+"ACTION_MOVE==dx=="+dx);
//                mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), dx, dy, 0);//第一步
                scrollTo(getScrollX()+dx,getScrollY()+dy);
//                invalidate();
                mLastY = y;
                mLastX = x;
                break;
            default:
        }
        return true;
    }

//    @Override
//    public void computeScroll() {
//        super.computeScroll();
//        if (mScroller.computeScrollOffset()) {//第二步
//            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());//第三步
//            invalidate();
//        }
//    }
}

