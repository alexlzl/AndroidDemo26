package com.example.demo6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        setTransparent(this);
        //隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        Button button = new Button(this);
//        WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams(
//                200, 400, WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.TYPE_APPLICATION, PixelFormat.TRANSPARENT);

// 这里对windowParam进行初始化
//        windowParams.flags=WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
//        windowParams.width=600;
//        windowParams.height=200;
//        windowParams.x=100;
//        windowParams.y=300;
// 获得应用PhoneWindow的WindowManager对象进行添加window

//getWindow().addContentView(button,windowParams);
//getWindow().setContentView(button);
//        getWindowManager().addView(button,windowParams);
        Window window =getWindow();
        WindowManager.LayoutParams windowLayoutParams = window.getAttributes();

        DisplayMetrics dm= new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeight =dm.heightPixels;
//        windowLayoutParams.height = screenHeight/2;
//        windowLayoutParams.alpha=50;
//        windowLayoutParams.width = screenHeight/2;
        window.setAttributes(windowLayoutParams);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
//                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);


    }

    public void test(View view){
        startActivity(new Intent(this,MainActivity2.class));
    }

    /**
     * 设置状态栏全透明
     *
     * @param activity 需要设置的activity
     */
    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        transparentStatusBar(activity);
        setRootView(activity);
    }

    /**
     * 使状态栏透明
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个flag contentView才能延伸到状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //状态栏覆盖在contentView上面，设置透明使contentView的背景透出来
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            //让contentView延伸到状态栏并且设置状态栏颜色透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 设置根布局参数
     */
    private static void setRootView(Activity activity) {
        ViewGroup parent = (ViewGroup) activity.findViewById(android.R.id.content);
        for (int i = 0, count = parent.getChildCount(); i < count; i++) {
            View childView = parent.getChildAt(i);
            if (childView instanceof ViewGroup) {
                childView.setFitsSystemWindows(true);
                ((ViewGroup) childView).setClipToPadding(true);
            }
        }
    }
}