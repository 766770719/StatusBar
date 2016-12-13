package com.zhx.statusbar.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.zhx.statusbar.SmartBarUtils;
import com.zhx.statusbar.StatusBarUtils;

/**
 * Fragment中使用
 * Created by xiezihao on 16/12/13.
 */
public class DemoFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fragment);

        //隐藏MX的SmartBar
        SmartBarUtils.hide(getWindow().getDecorView());

        //透明状态栏,填充的控件在Fragment中,这里没有控件填null
        StatusBarUtils.translucentStatusBar(this, null);
    }
}
