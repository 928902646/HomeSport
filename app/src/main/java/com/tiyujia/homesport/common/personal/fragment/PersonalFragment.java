package com.tiyujia.homesport.common.personal.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tiyujia.homesport.BaseFragment;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.activity.PersonalActive;
import com.tiyujia.homesport.common.personal.activity.PersonalAttention;
import com.tiyujia.homesport.common.personal.activity.PersonalDynamic;
import com.tiyujia.homesport.common.personal.activity.PersonalEquipmentShow;
import com.tiyujia.homesport.common.personal.activity.PersonalFans;
import com.tiyujia.homesport.common.personal.activity.PersonalLogin;
import com.tiyujia.homesport.common.personal.activity.PersonalMsg;
import com.tiyujia.homesport.common.personal.activity.PersonalPanyanGold;
import com.tiyujia.homesport.common.personal.activity.PersonalSystemSetting;
import com.tiyujia.homesport.util.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zzqybyb19860112 on 2016/10/18.
 */
public class PersonalFragment extends BaseFragment implements View.OnClickListener{

    @Bind(R.id.iv_msg) ImageView iv_msg;
    @Bind(R.id.iv_setting) ImageView iv_setting;
    @Bind(R.id.me_head) ImageView me_head;
    @Bind(R.id.iv_lv) TextView iv_lv;
    @Bind(R.id.tv_name) TextView tv_name;
    @Bind(R.id.tv_intro) TextView tv_intro;
    @Bind(R.id.ll_attention) LinearLayout ll_attention;
    @Bind(R.id.ll_fans) LinearLayout ll_fans;
    @Bind(R.id.ll_gold) LinearLayout ll_gold;
    @Bind(R.id.ll_user) LinearLayout ll_user;
    @Bind(R.id.re_active) RelativeLayout re_active;
    @Bind(R.id.re_dynamic) RelativeLayout re_dynamic;
    @Bind(R.id.re_show) RelativeLayout re_show;
    @Bind(R.id.re_login) RelativeLayout re_login;
    @Bind(R.id.btn_login)    Button btn_login;
    private SharedPreferences mShare;
    private String mToken,mUserId;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_home_fragment,null);
        ButterKnife.bind(this, view);
        getInfo();
        return view;
    }

    private void getInfo() {
        mShare= getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        mToken=mShare.getString("Token","");
        if(TextUtils.isEmpty(mToken)){
            ll_user.setVisibility(View.GONE);
        }else {
            re_login.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {

        iv_msg.setOnClickListener(this);
        iv_setting.setOnClickListener(this);
        me_head.setOnClickListener(this);
        iv_lv.setOnClickListener(this);
        ll_attention.setOnClickListener(this);
        ll_fans.setOnClickListener(this);
        ll_gold.setOnClickListener(this);
        re_active.setOnClickListener(this);
        re_dynamic.setOnClickListener(this);
        re_show.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_msg:
                getActivity().startActivity(new Intent(getActivity(), PersonalMsg.class));
                break;
            case R.id.iv_setting:
                getActivity().startActivity(new Intent(getActivity(), PersonalSystemSetting.class));
                break;
            case R.id.me_head:
                Toast.makeText(getActivity(),"hdksajhdksja",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_attention:
                getActivity().startActivity(new Intent(getActivity(), PersonalAttention.class));
                break;
            case R.id.ll_fans:
                getActivity().startActivity(new Intent(getActivity(), PersonalFans.class));
                break;
            case R.id.ll_gold:
                getActivity().startActivity(new Intent(getActivity(), PersonalPanyanGold.class));
                break;
            case R.id.re_active:
                getActivity().startActivity(new Intent(getActivity(), PersonalActive.class));
                break;
            case R.id.re_dynamic:
                getActivity().startActivity(new Intent(getActivity(), PersonalDynamic.class));
                break;
            case R.id.re_show:
                getActivity().startActivity(new Intent(getActivity(), PersonalEquipmentShow.class));
                break;
            case R.id.btn_login:
                getActivity().startActivity(new Intent(getActivity(), PersonalLogin.class));
                break;
        }
    }
}
