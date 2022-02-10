package com.example.demo3

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val button=findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
        //setComponent()在Android 7.0及以下版本不是必须的，但是Android 8.0或者更高版本，发送广播的条件更加严苛，必须添加这一行内容
        sendBroadcast(Intent("com.test.broadcast").setComponent(ComponentName("com.example.demo3","com.example.demo3.MyBroadcastReceiver")))

    }
}