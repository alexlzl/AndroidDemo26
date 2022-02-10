package com.example.demo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.TextView
import com.example.demo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text=findViewById<TextView>(R.id.text)
        text.text= "taskid==$taskId"

    }

    fun click(view: View){
//        SystemClock.sleep(20*1000)
        val intent=Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }
}