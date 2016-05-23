package com.zhx.statusbar;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/**
 * 用于键盘显示区域的View，必须放在布局最后一个View的位置
 * Created by owner on 2016/4/20.
 */
public class KeyboardDisplayView extends FrameLayout {

    public KeyboardDisplayView(Context context) {
        super(context);
        init();
    }

    public KeyboardDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyboardDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (StatusBarUtils.canTranslucentStatusBar(getContext())) //可以透明状态栏
            setFitsSystemWindows(true);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) //api20以上
            insets = insets.replaceSystemWindowInsets(0, 0, 0, insets.getSystemWindowInsetBottom());
        return super.dispatchApplyWindowInsets(insets);
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT_WATCH) //api20以下
            insets.left = insets.right = insets.top = 0;
        return super.fitSystemWindows(insets);
    }
}
