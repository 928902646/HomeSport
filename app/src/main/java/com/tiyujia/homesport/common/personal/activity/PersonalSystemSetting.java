package com.tiyujia.homesport.common.personal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

/**
 * 作者: Cymbi on 2016/10/19 15:33.
 * 邮箱:928902646@qq.com
 */

public class PersonalSystemSetting extends ImmersiveActivity implements View.OnClickListener{
    private ImageView back;
    private TextView tvData,tvFeedback,tvAbout,tvComment;
    private RelativeLayout tvClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_setting);
        setview();
    }

    private void setview() {
        back=(ImageView)findViewById(R.id.back);
        tvData=(TextView)findViewById(R.id.tvData);
        tvAbout=(TextView)findViewById(R.id.tvAbout);
        tvComment=(TextView)findViewById(R.id.tvComment);
        tvClean=(RelativeLayout)findViewById(R.id.tvClean);
        tvFeedback=(TextView)findViewById(R.id.tvFeedback);
        back.setOnClickListener(this);
        tvData.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
        tvComment.setOnClickListener(this);
        tvClean.setOnClickListener(this);
        tvFeedback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.tvData:
                break;
            case R.id.tvAbout:
                break;
            case R.id.tvComment:
                break;
            case R.id.tvClean:
                break;
            case R.id.tvFeedback:
                Intent i=new Intent(this,FeedBackActivity.class);
                startActivity(i);
                break;
        }

    }
}
