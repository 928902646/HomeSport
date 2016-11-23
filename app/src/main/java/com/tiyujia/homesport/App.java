package com.tiyujia.homesport;

import android.app.Application;
import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

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

        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数");
        //-----------------------------------------------------------------------------------//

        OkGo.init(this);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
    }
    public static Context getContext() {
        return mContext;
    }
}
