# StatusBar
沉浸式状态栏、状态栏相关

<img width="400" height="720" src="https://github.com/766770719/Resources/blob/master/StatusBar/statusbar.png" />

###Gradle:
[![](https://jitpack.io/v/766770719/StatusBar.svg)](https://jitpack.io/#766770719/StatusBar)

###使用:
#####1.在Activity中:
```
public class DemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo);

        //隐藏魅族的SmartBar,这句话可要可不要，不是必须
        SmartBarUtils.hide(getWindow().getDecorView());

        //透明状态栏
        StatusBarUtils.translucentStatusBar(this, findViewById(R.id.v_title));

        //解决:android:windowSoftInputMode=adjustResize,键盘弹出UI无法Resize问题 --> 布局XML中最后加入:KeyboardDisplayView(参考demo)
        //注意:在使用KeyboardDisplayView的布局中，不能出现:android:fitsSystemWindows="true"
    }
}
```

#####2.在Fragment中:
```
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
```
