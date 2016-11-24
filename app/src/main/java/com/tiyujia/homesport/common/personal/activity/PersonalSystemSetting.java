package com.tiyujia.homesport.common.personal.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.util.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: Cymbi on 2016/10/19 15:33.
 * 邮箱:928902646@qq.com
 */

public class PersonalSystemSetting extends ImmersiveActivity implements View.OnClickListener{
    @Bind(R.id.personal_back) ImageView personal_back;
    @Bind(R.id.re_info) RelativeLayout re_info;
    @Bind(R.id.re_attestation) RelativeLayout re_attestation;
    @Bind(R.id.re_grade) RelativeLayout re_grade;
    @Bind(R.id.re_clean) RelativeLayout re_clean;
    @Bind(R.id.re_about) RelativeLayout re_about;
    @Bind(R.id.re_feedback) RelativeLayout re_feedback;
    @Bind(R.id.tv_loginout) TextView tv_loginout;
    @Bind(R.id.togglebutton)ToggleButton togglebutton;
    @Bind(R.id.tv_title)TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_setting);
        setview();
    }

    private void setview() {
        tv_title.setText("设置");
        personal_back.setOnClickListener(this);
        re_info.setOnClickListener(this);
        re_attestation.setOnClickListener(this);
        re_grade.setOnClickListener(this);
        re_clean.setOnClickListener(this);
        re_feedback.setOnClickListener(this);
        tv_loginout.setOnClickListener(this);
        re_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_back:
                finish();
                break;
            case R.id.re_info:
                startActivity(new Intent(this,PersonalSetInfo.class));
                break;
            case R.id.re_attestation:
                break;
            case R.id.re_grade:

                break;
            case R.id.re_clean:

                break;
            case R.id.re_feedback:
                startActivity(new Intent(this,PersonalFeedback.class));
                break;
            case R.id.tv_loginout:
                SharedPreferences share = getSharedPreferences("UserInfo",MODE_PRIVATE);
                SharedPreferences.Editor etr=share.edit();
                etr.clear().commit();
                break;
            case R.id.re_about:
                startActivity(new Intent(this,PersonalAbout.class));

                break;
        }
    

    }


}
