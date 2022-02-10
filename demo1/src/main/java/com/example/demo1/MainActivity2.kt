package com.example.demo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.demo.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
//        val text=findViewById<TextView>(R.id.text_bottom)
//        text.text="taskid==$taskId"
        while (true){
//            Log.e("tag","ss")
        }
    }

    fun click(view: View){
        startActivity(Intent(this,MainActivity3::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}