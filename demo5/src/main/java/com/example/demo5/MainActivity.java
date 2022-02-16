package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String BROADCAST_PERMISSION_DISC = "com.cn.customview.permissions.MY_BROADCAST";
    private static final String BROADCAST_ACTION_DISC = "com.cn.customview.permissions.my_broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 注册广播接收
        BroadcastReceiver receiveBroadCast = new ReceiveBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction(BROADCAST_ACTION_DISC); // 只有持有相同的action的接受者才能接收此广播
        registerReceiver(receiveBroadCast, filter, null, null);
    }

    public class ReceiveBroadCast extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this,
                    "动态注册的广播", Toast.LENGTH_LONG).show();
        }
    }
}