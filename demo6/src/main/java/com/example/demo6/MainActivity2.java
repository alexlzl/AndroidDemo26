package com.example.demo6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No Title bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
////        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
//
//        //设置背景
//        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.img));
//        Bitmap bitmapDial = BitmapFactory.decodeResource(getResources(),R.drawable.img_1);
//        WindowManager.LayoutParams param = getWindow().getAttributes();//获取对话框当前的参数值
//        param.width = bitmapDial.getWidth();
//        param.height = bitmapDial.getHeight();
//        getWindow().setAttributes((android.view.WindowManager.LayoutParams)param);//设置生效
//        //确定界面的布局
//        AbsoluteLayout abslayout=new AbsoluteLayout (this);
//        setContentView(abslayout);
//        // 提示信息
//        TextView tMsg = new TextView(this);
//        tMsg.setText(R.string.app_name);
//        tMsg.setTypeface(Typeface.create("宋体", Typeface.BOLD_ITALIC));
//        tMsg.setTextSize(30);
//        tMsg.setGravity(Gravity.CENTER);
//        //确定这个控件的大小和位置
//        AbsoluteLayout.LayoutParams lpParam = new AbsoluteLayout.LayoutParams(bitmapDial.getWidth(),bitmapDial.getHeight(),0,0);
//        abslayout.addView(tMsg, lpParam);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        finish();
        return super.onTouchEvent(event);
    }

    public void show(View view){
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
    }

}