package com.example.scroller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class ScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int mLastX;
    private int mLastY;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int y = (int) event.getY();
//        int x = (int) event.getX();
//        int action = event.getAction();
//        View decorView = getWindow().getDecorView();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                mLastY = y;
//                mLastX = x;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int dy = mLastY - y;//本次手势滑动了多大距离
//                int dx = mLastX - x;
//                int oldScrollY = decorView.getScrollY();//先计算之前已经偏移了多少距离
//                int oldScrollX = decorView.getScrollX();
//                int scrollY = oldScrollY + dy;//本次需要偏移的距离=之前已经偏移的距离+本次手势滑动了多大距离
//                int scrollX = oldScrollX + dx;
//                decorView.scrollTo(scrollX, scrollY);
//                mLastY = y;
//                mLastX = x;
//                break;
//        }
//        return true;
//    }
}
