package com.tiyujia.homesport.common.homepage.service;

import com.tiyujia.homesport.common.homepage.net.Result;
import com.tiyujia.homesport.entity.UserData;

import rx.Observable;

/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

    public interface UserService extends Service{
        public Observable<Result> getVerifyCode(String phone);
        public Observable<Result<VerifyCode>> verifyPhone(String phone, String code);
        public Observable<Result> register(String phone, String pwd, String nickname, String avatar);
        public Observable<Result> retrievePassword(String phone, String pwd, String re_pwd);
        public Observable<Result<UserData>> login(String phone, String pwd);
}
