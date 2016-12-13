package com.zhx.statusbar.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhx.statusbar.StatusBarUtils;

/**
 * DemoFragment
 * Created by xiezihao on 16/12/13.
 */
public class DemoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_demo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //透明状态栏
        StatusBarUtils.translucentStatusBar(this, view.findViewById(R.id.v_title));

        //解决:android:windowSoftInputMode=adjustResize,键盘弹出UI无法Resize问题 --> 布局XML中最后加入:KeyboardDisplayView(参考demo)
        //注意:在使用KeyboardDisplayView的布局中，不能出现:android:fitsSystemWindows="true"
    }
}
