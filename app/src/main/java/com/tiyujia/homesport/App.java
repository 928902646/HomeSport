package com.tiyujia.homesport;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.lzy.okgo.OkGo;
import com.tiyujia.homesport.common.homepage.fragment.HomePageFragment;

/**
 * 作者: Cymbi on 2016/10/19 17:25.
 * 邮箱:928902646@qq.com
 */

public class App extends Application {
    private static Context mContext = null;
    public static boolean debug = true;
    public static AMapLocationClient mLocationClient = null;
    public static String nowCity=null;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        OkGo.init(this);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        AMapLocationClientOption option=new AMapLocationClientOption();
        resetOption(option);
        AMapLocationListener locationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation loc) {
                if (null != loc) {
                    //解析定位结果
                    nowCity = loc.getCity();
                }
            }
        };
        mLocationClient.setLocationOption(option);
        // 启动定位
        mLocationClient.startLocation();
        mLocationClient.setLocationListener(locationListener);
    }
    public static Context getContext() {
        return mContext;
    }

    private   void resetOption(AMapLocationClientOption option) {
        option= new AMapLocationClientOption();
        option.setNeedAddress(true);
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        option.setGpsFirst(true);
        // 设置是否开启缓存
        option.setLocationCacheEnable(true);
        //设置是否等待设备wifi刷新，如果设置为true,会自动变为单次定位，持续定位时不要使用
        option.setOnceLocationLatest(true);
        //设置是否使用传感器
        option.setSensorEnable(true);
        String strInterval = "300";
        if (!TextUtils.isEmpty(strInterval)) {
            try{
                // 设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
                option.setInterval(Long.valueOf(strInterval));
            }catch(Throwable e){
                e.printStackTrace();
            }
        }

        String strTimeout = "30000";
        if(!TextUtils.isEmpty(strTimeout)){
            try{
                // 设置网络请求超时时间
                option.setHttpTimeOut(Long.valueOf(strTimeout));
            }catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
}
