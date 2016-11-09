package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tiyujia.homesport.ImmersiveActivity;

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
    }

    @Override
    public void onClick(View v) {
    }
}
