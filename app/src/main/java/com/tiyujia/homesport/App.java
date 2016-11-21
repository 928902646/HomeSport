package com.tiyujia.homesport;

import android.app.Application;
import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.lzy.okgo.OkGo;

/**
 * 作者: Cymbi on 2016/10/19 17:25.
 * 邮箱:928902646@qq.com
 */

public class App extends Application {
    private static Context mContext = null;
    public static boolean debug = true;
    public static AMapLocationClient mLocationClient = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        OkGo.init(this);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
    }
    public static Context getContext() {
        return mContext;
    }
}
