package com.ylz.componentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    //这边在实际引入各个组件的时候，会出现一个Caused by: java.lang.IllegalStateException:
    // This Activity already has an action bar supplied by the window decor.
    // Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false
    // in your theme to use a Toolbar instead.
    //因为BaseActivity中我用了toolbar，但是如果将主题改为NoActionBar的话，就会出现toolbar空指针的问题
    //后来发现BaseActivity判断supportActionBar不为空错了，应该是为空，但是改了还是空指针。。
    //但是有个kotlin的应用跑来就完全没问题，不知道是不是toolbar实例获取的问题
    //最后发现只是初始化的时候把setContentView顺序放错，放在初始化toolbar后面了...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance()
                .build("/homepage/HomePageActivity")
                .navigation();
        finish();
    }
}