package com.example.demo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyTextView(this));
    }
}
 class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    int i = 0;

     public MyTextView(Context context) {
         super(context);
     }

     @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Thread.sleep(16);
        } catch (Exception e) {
        }
        if (i < 6) {
            this.post(new Runnable() {
                @Override
                public void run() {
                    MyTextView.this.setText(i++ + "");
                }
            });
        }
    }
}