package com.tiyujia.homesport.common.homepage.service;



import com.tiyujia.homesport.common.homepage.net.Result;
import com.tiyujia.homesport.common.homepage.entity.HomePageData;

import rx.Observable;

/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

public interface HomePageService extends Service {
    public Observable<Result<HomePageData>> getAllHotInfo();
}
