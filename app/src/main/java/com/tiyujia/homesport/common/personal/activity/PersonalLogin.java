package com.tiyujia.homesport.common.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.tiyujia.homesport.API;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 作者: Cymbi on 2016/11/22 16:00.
 * 邮箱:928902646@qq.com
 */

public class PersonalLogin extends ImmersiveActivity implements View.OnClickListener{
    @Bind(R.id.tvRegister)    TextView tvRegister;
    @Bind(R.id.tvLogin)    TextView tvLogin;
    @Bind(R.id.ivBack)    ImageView ivBack;
    @Bind(R.id.etPhone)    EditText etPhone;
    @Bind(R.id.etPassword)    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setView();
    }

    private void setView() {
        ivBack.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvRegister:
                startActivity(new Intent(this,PersonalRegister.class));
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.tvLogin:
                String phone=etPhone.getText().toString();
                String pwd=etPassword.getText().toString();
                if(!TextUtils.isEmpty(phone)){
                   if(!TextUtils.isEmpty(pwd)){
                       HashMap<String, String> params = new HashMap<>();
                       params.put("phone", phone);
                       params.put("pwd", pwd);
                       JSONObject jsonObject = new JSONObject(params);
                       OkGo.post(API.BASE_URL+"/v2/account/log_in")
                               .tag(this)
                               .upJson(jsonObject.toString())//
                               .execute(new StringCallback(){
                                   @Override
                                   public void onSuccess(String s, Call call, Response response) {
                                       showToast("成功");
                                   }

                                   @Override
                                   public void onError(Call call, Response response, Exception e) {
                                       super.onError(call, response, e);
                                       showToast("失败");
                                   }
                               });
                   }else {showToast("密码不能为空");}
                }else { showToast("账号不能为空");}



                break;
        }
    }
}
