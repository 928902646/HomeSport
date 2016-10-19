package com.tiyujia.homesport;

import android.app.Application;

import com.lzy.okgo.OkGo;

/**
 * 作者: Cymbi on 2016/10/19 17:25.
 * 邮箱:928902646@qq.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.init(this);
    }
}
