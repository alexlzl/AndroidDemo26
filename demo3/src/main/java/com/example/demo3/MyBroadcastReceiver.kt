package com.example.demo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *
 * @ Author： LiuZhouLiang
 *
 * @ Time：  2022/2/9 5:55 下午
 *
 * @ Description：
 *
 *
 */
class MyBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"test",Toast.LENGTH_LONG).show()
    }
}