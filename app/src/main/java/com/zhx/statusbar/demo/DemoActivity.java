package com.zhx.statusbar.demo;

import android.app.Activity;
import android.os.Bundle;

import com.zhx.statusbar.SmartBarUtils;
import com.zhx.statusbar.StatusBarUtils;

/**
 * Demo
 * Created by owner on 2016/5/23.
 */
public class DemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //隐藏MX的SmartBar
        SmartBarUtils.hide(getWindow().getDecorView());

        //透明状态栏
        StatusBarUtils.translucentStatusBar(this, findViewById(R.id.v_title));

        //解决:android:windowSoftInputMode=adjustResize,键盘弹出UI无法Resize问题 --> 布局XML中最后加入:KeyboardDisplayView自定义View
    }
}
