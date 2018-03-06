package com.joy.alertwindowtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        testSwitch();
    }

    private void testSwitch() {
        switch ("a") {
            case "a":
            case "b":
                startService(new Intent(this, AlertWindowService.class));
                break;
            case "c":
                String s = "";
                break;
        }
    }
}
