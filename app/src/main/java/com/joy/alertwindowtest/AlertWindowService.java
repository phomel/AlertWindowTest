package com.joy.alertwindowtest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * <pre>
 *     author : huangyacong
 *     e-mail : 17826817008@163.com
 *     time   : 2017/4/11
 *     desc   : xx页面
 *     version: 1.0
 * </pre>
 */
public class AlertWindowService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final WindowManager manager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        final View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.float_window_small, null);
        final Button button = (Button) view.findViewById(R.id.percent);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;//默认alertWindow出现后所有的view不可点击,通过flag修改
        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.gravity = Gravity.CENTER | Gravity.TOP;
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.windowAnimations = R.style.pop_add_ainm;
        manager.addView(view, layoutParams);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "啊哈哈", Toast.LENGTH_SHORT).show();
                manager.removeView(view);
            }
        }, 3000L);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(getApplicationContext(), "aiyouwei", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
