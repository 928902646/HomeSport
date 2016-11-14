package com.tiyujia.homesport.common.homepage.service;

import com.tiyujia.homesport.common.homepage.net.HomePageResult;
import com.tiyujia.homesport.entity.UserData;

import java.util.HashMap;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;
/**
 * Created by zzqybyb19860112 on 2016/11/10.
 */

public interface HomePageUserApi {
    /**
     * 获取验证码
     */
    @POST("/v1/sendRegisterCode") @FormUrlEncoded
    Observable<HomePageResult> getVerifyCode(
            @FieldMap HashMap<String, String> params);
    /**
     * 验证手机号
     */
    @POST("/v1/account/validate/code") @FormUrlEncoded Observable<HomePageResult<HomePageVerifyCode>> verifyPhone(
            @FieldMap HashMap<String, String> params);
    /**
     * 注册账号
     */
    @Multipart
    @POST("/v1/account/register") Observable<HomePageResult> register(
            @PartMap HashMap<String, RequestBody> params);
    /**
     * 忘记密码
     */
    @POST("/v1/account/retrievepwd") @FormUrlEncoded Observable<HomePageResult> retrievePassword(
            @FieldMap HashMap<String, String> params);
    /**
     * 登录
     */
    @POST("/v1/account/login") @FormUrlEncoded Observable<HomePageResult<UserData>> login(
            @FieldMap HashMap<String, String> params);
}

