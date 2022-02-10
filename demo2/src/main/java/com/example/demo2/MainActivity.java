package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{

    Button registerStickbt;
    Button registerNormalbt;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendStickyBroadcast(new Intent("com.example.stickybroadcastdemo.stickybrocast"));  //发送粘性广播
        sendBroadcast(new Intent("com.example.stickybroadcastdemo.normalbrocast"));       //发送普通广播
        registerStickbt=(Button)findViewById(R.id.registerstick);
        registerNormalbt=(Button)findViewById(R.id.registernormal);
        mTextView=(TextView)findViewById(R.id.result);
        registerStickbt.setOnClickListener(this);
        registerNormalbt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.registerstick:
                IntentFilter intentFilter = new IntentFilter("com.example.stickybroadcastdemo.stickybrocast");
                Intent data = registerReceiver(null, intentFilter);  //接收、注意第一个参数
                if(data != null && data.getAction().equals("com.example.stickybroadcastdemo.stickybrocast"))
                {
//                    Toast.makeText(this, getText(R.string.toast), Toast.LENGTH_SHORT).show();
                    Toast toast= Toast.makeText(this, "", Toast.LENGTH_SHORT);
                    toast.setText("get test");
                    toast.show();
                }

//                registerReceiver(stickreceiver, new IntentFilter("com.example.stickybroadcastdemo.stickybrocast")); //注册粘性广播接收器
                break;

            case R.id.registernormal:
                registerReceiver(normalreceiver, new IntentFilter("com.example.stickybroadcastdemo.normalbrocast"));//注册普通广播接收器
                break;

            default:
                break;
        }

    }
 int a;
    BroadcastReceiver stickreceiver=new BroadcastReceiver(){            //粘性广播接收器
        public void onReceive(android.content.Context context, Intent intent) {
            a++;
            mTextView.setText("recevier stick broadcast!"+a);
        };
    };

    BroadcastReceiver normalreceiver=new BroadcastReceiver(){          //普通广播接收器
        public void onReceive(android.content.Context context, Intent intent) {
            mTextView.setText("recevier normal broadcast!");
        };
    };
  public void test(View view){
//      Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
//      Toast mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
//      mToast.setText("message");
//      mToast.show();
      LSToast.getInstance(this).show("test",2000);
  }
}