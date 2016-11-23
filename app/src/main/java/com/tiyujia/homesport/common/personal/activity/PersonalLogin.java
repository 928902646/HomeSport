package com.tiyujia.homesport.common.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import butterknife.Bind;

/**
 * 作者: Cymbi on 2016/11/22 16:00.
 * 邮箱:928902646@qq.com
 */

public class PersonalLogin extends ImmersiveActivity implements View.OnClickListener{
    @Bind(R.id.tvRegister)
    TextView tvRegister;
    @Bind(R.id.ivBack)
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setView();
    }

    private void setView() {
        ivBack.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
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
        }
    }
}
