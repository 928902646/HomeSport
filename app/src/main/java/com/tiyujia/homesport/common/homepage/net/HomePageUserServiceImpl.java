package com.tiyujia.homesport.common.homepage.net;

import com.tiyujia.homesport.App;
import com.tiyujia.homesport.common.homepage.service.HomePageUserApi;
import com.tiyujia.homesport.common.homepage.service.UserService;
import com.tiyujia.homesport.common.homepage.service.HomePageVerifyCode;
import com.tiyujia.homesport.entity.UserData;
import com.tiyujia.homesport.util.RetrofitUtil;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

public class HomePageUserServiceImpl implements UserService {
    HomePageUserApi api;
    public HomePageUserServiceImpl() {
        api = RetrofitUtil.createApi(App.getContext(), HomePageUserApi.class);
    }
    @Override public Observable<HomePageResult> getVerifyCode(String phone) {
        HashMap<String, String> params = new HashMap<>();
        params.put("phone", phone);
        return api.getVerifyCode(params);
    }
    @Override public Observable<HomePageResult<HomePageVerifyCode>> verifyPhone(String phone, String code) {
        HashMap<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("code", code);
        return api.verifyPhone(params);
    }
    @Override
    public Observable<HomePageResult> register(String phone, String pwd, String nickname, String avatar) {
        HashMap<String, RequestBody> params = new HashMap<>();
        params.put("phone", RequestBody.create(MediaType.parse("text/plain"), phone));
        params.put("pwd", RequestBody.create(MediaType.parse("text/plain"), pwd));
        params.put("nickname", RequestBody.create(MediaType.parse("text/plain"), nickname));
        if (avatar != null) {
            params.put("avatar", RequestBody.create(MediaType.parse("image/*"), new File(avatar)));
        }
        return api.register(params);
    }
    @Override public Observable<HomePageResult> retrievePassword(String phone, String pwd, String re_pwd) {
        HashMap<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("pwd", pwd);
        params.put("re_pwd", re_pwd);
        return api.retrievePassword(params);
    }
    @Override public Observable<HomePageResult<UserData>> login(String phone, String pwd) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("phone", phone);
        params.put("pwd", pwd);
        return api.login(params);
    }
}

