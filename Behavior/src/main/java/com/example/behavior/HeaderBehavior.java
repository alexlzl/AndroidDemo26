package com.example.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * @ Author： LiuZhouLiang
 * @ Time： 2022/3/28 10:37 上午
 * @ Description：
 */

public class HeaderBehavior extends CoordinatorLayout.Behavior<View> {
    // 记录手指触摸的位置
    private int mLastY = 0;

    public HeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull View child, MotionEvent ev) {
        // 手指触摸的回调
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int y = (int) ev.getRawY();
                child.setTranslationY(child.getTranslationY() + y - mLastY);
                mLastY = y;
                break;
        }
        return true;
    }
}
