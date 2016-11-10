package com.tiyujia.homesport.common.personal.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.util.StatusBarUtil;

/**
 * 作者: Cymbi on 2016/10/19 15:33.
 * 邮箱:928902646@qq.com
 */

public class PersonalSystemSetting extends ImmersiveActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_setting);
    }
    @Override
    public void onClick(View v) {
    }


}
