package com.tiyujia.homesport.common.homepage.service;

import com.tiyujia.homesport.common.homepage.net.HomePageResult;
import com.tiyujia.homesport.entity.UserData;

import rx.Observable;

/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

    public interface UserService extends Service{
        public Observable<HomePageResult> getVerifyCode(String phone);
        public Observable<HomePageResult<HomePageVerifyCode>> verifyPhone(String phone, String code);
        public Observable<HomePageResult> register(String phone, String pwd, String nickname, String avatar);
        public Observable<HomePageResult> retrievePassword(String phone, String pwd, String re_pwd);
        public Observable<HomePageResult<UserData>> login(String phone, String pwd);
}
