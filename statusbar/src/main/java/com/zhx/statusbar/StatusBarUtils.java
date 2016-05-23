package com.zhx.statusbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;

/**
 * 状态栏工具类
 * Created by xzh on 2015/12/24 0024.
 */
public class StatusBarUtils {

    /**
     * 获取状态栏高度
     *
     * @param ctx 上下文
     * @return 0 没有获取到高度(px)
     */
    public static int getStatusBarHeight(Context ctx) {
        Resources res = ctx.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return res.getDimensionPixelOffset(resourceId);
        }
        return 0;
    }

    /**
     * 是否支持透明状态栏
     *
     * @param ctx 上下文
     * @return true支持
     */
    public static boolean canTranslucentStatusBar(Context ctx) {
        return getStatusBarHeight(ctx) != 0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT; //可以获取状态栏高度、版本大于4.4
    }

    /**
     * 透明状态栏
     *
     * @param act                   Activity
     * @param fitsSystemWindowsView 填充状态栏颜色的View
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void translucentStatusBar(Activity act, View fitsSystemWindowsView) {
        if (canTranslucentStatusBar(act)) { //可以透明状态栏
            act.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setStatusBarColor(fitsSystemWindowsView);
        }
    }

    /**
     * 只填充状态栏颜色，不设置Activity状态栏透明{@link #translucentStatusBar(Activity, View)}
     *
     * @param fragment              fragment
     * @param fitsSystemWindowsView 填充状态栏颜色的View
     */
    public static void translucentStatusBar(Fragment fragment, View fitsSystemWindowsView) {
        if (canTranslucentStatusBar(fragment.getContext())) { //可以透明状态栏
            setStatusBarColor(fitsSystemWindowsView);
        }
    }

    /**
     * 设置状态栏颜色通过View
     *
     * @param view view
     */
    private static void setStatusBarColor(View view) {
        if (view != null) { //存在填充View,填充状态栏颜色
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(view.getContext()),
                    view.getPaddingRight(), view.getPaddingBottom());
        }
    }
}
