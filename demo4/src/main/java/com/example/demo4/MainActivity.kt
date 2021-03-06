package com.example.demo4

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val  BROADCAST_PERMISSION_DISC = "com.cn.customview.permissions.MY_BROADCAST";
    private val    BROADCAST_ACTION_DISC = "com.cn.customview.permissions.my_broadcast";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv=findViewById<TextView>(R.id.tv_send)
        tv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      Toast.makeText(this,"start",Toast.LENGTH_LONG).show()

        //显示发送信息给静态注册的广播
        sendBroadcast(Intent("com.test.broadcast").setFlags(Intent.FLAG_RECEIVER_FOREGROUND).setComponent(ComponentName("com.example.demo3","com.example.demo3.MyBroadcastReceiver")))
        //隐式发送信息给动态注册的广播
//        sendBroadcastWithPermissions()

    }
  private  fun sendBroadcastWithPermissions() {
        val intent = Intent() //Itent就是我们要发送的内容
        intent.putExtra(
            "data",
            "this is data from broadcast " + Calendar.getInstance().get(Calendar.SECOND)
        )
        intent.action = BROADCAST_ACTION_DISC //设置你这个广播的action，只有和这个action一样的接受者才能接受者才能接收广播
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent, null) //发送广播
    }
}