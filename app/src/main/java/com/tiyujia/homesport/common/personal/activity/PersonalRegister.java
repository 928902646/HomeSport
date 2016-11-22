package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

import butterknife.Bind;

/**
 * 作者: Cymbi on 2016/11/22 18:02.
 * 邮箱:928902646@qq.com
 */

public class PersonalRegister extends ImmersiveActivity implements View.OnClickListener{
    @Bind(R.id.ivBack)
    TextView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activcity);
        setView();
    }

    private void setView() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
