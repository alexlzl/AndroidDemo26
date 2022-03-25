package com.example.demo8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.Choreographer;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyFrameCallback mFrameCallback = new MyFrameCallback();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Choreographer.getInstance().postFrameCallback(mFrameCallback);

        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiLongTimeWork();
            }
        });
    }

    public class MyFrameCallback implements Choreographer.FrameCallback {
        private String TAG = "性能检测";
        private long lastTime = 0;

        @Override
        public void doFrame(long frameTimeNanos) {
            if (lastTime == 0) {
                //代码第一次初始化。不做检测统计。
                lastTime = frameTimeNanos;
            } else {
                long times = (frameTimeNanos - lastTime) / 1000000;
                int frames = (int) (times / 16);

                if (times > 16) {
                    Log.w("TAG", "UI线程超时(超过16ms):" + times + "ms" + " , 丢帧:" + frames);
                }

                lastTime = frameTimeNanos;
            }

            Choreographer.getInstance().postFrameCallback(mFrameCallback);
        }
    }

    private void uiLongTimeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}