package com.example.scroller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText=findViewById(R.id.tv_context);
    }

    public void test(View view){
        View parent= (View) findViewById(R.id.tv_context).getParent();
//        parent.scrollBy(5,5);
        Log.e("TAG","scrolly=="+parent.getScrollY()+"===scrollx"+parent.getScrollX());
        parent.scrollTo(parent.getScrollX()+5,parent.getScrollY()+5);
    }
}