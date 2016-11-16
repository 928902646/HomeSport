package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

import butterknife.Bind;

/**
 * 作者: Cymbi on 2016/11/10 17:29.
 * 邮箱:928902646@qq.com
 */

public class PersonalSetInfo extends ImmersiveActivity implements View.OnClickListener {
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_set_info);
        tv_title.setText("个人资料");
    }

    @Override
    public void onClick(View v) {

    }
}
