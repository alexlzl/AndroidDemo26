package com.example.demo2;

/**
 * @ Author： LiuZhouLiang
 * @ Time： 2022/2/9 4:15 下午
 * @ Description：
 */
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;



public class LSToast extends Toast {
    private Context mContext;
    private Toast toast;
    public static LSToast lsToast;
    private View toastView;

    public LSToast(Context context) {
        super(context);
        this.mContext = context;
        toastView = LayoutInflater.from(context).inflate(R.layout.layout_lstoast, null);

        if (null == toast) {
            toast = new Toast(context);
        }

    }

    public static LSToast getInstance(Context context) {
//        if (null == lsToast) {
        lsToast = new LSToast(context);
//        }
        return lsToast;
    }


    /**
     *
     * @param str
     * @param duration
     */
    public void show(String str,int duration){
        toast.setDuration(duration);
        TextView textView = toastView.findViewById(R.id.tv_ls_toast);
        textView.setText(str);
        toast.setView(toastView);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 10*1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, 10*1000 );
    }
}

