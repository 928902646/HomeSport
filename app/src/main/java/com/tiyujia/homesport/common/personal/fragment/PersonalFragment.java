package com.tiyujia.homesport.common.personal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tiyujia.homesport.BaseFragment;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.activity.PersonalActive;
import com.tiyujia.homesport.common.personal.activity.PersonalSystemSetting;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zzqybyb19860112 on 2016/10/18.
 */
public class PersonalFragment extends BaseFragment implements View.OnClickListener{

    @Bind(R.id.iv_msg) ImageView iv_msg;
    @Bind(R.id.iv_setting) ImageView iv_setting;
    @Bind(R.id.me_head) ImageView me_head;
    @Bind(R.id.iv_lv) ImageView iv_lv;
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

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_home_fragment,null);
        ButterKnife.bind(this, view);
        return view;
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
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_msg:
                Toast.makeText(getActivity(),"hdksajhdksja",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_setting:
                getActivity().startActivity(new Intent(getActivity(), PersonalSystemSetting.class));
                break;
            case R.id.me_head:
                Toast.makeText(getActivity(),"hdksajhdksja",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_lv:

                break;
            case R.id.ll_attention:

                break;
            case R.id.ll_fans:

                break;
            case R.id.ll_gold:

                break;
            case R.id.re_active:
                getActivity().startActivity(new Intent(getActivity(), PersonalActive.class));
                break;
            case R.id.re_dynamic:

                break;
            case R.id.re_show:

                break;
        }
    }
}
