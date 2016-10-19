package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

/**
 * 作者: Cymbi on 2016/10/19 16:14.
 * 邮箱:928902646@qq.com
 */

public class FeedBackActivity extends ImmersiveActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_activity);
        TextView tvPush=(TextView)findViewById(R.id.tvPush);
        ImageView ivFeedBack=(ImageView)findViewById(R.id.ivFeedBack);
        ivFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedBackActivity.this,"非常感谢！您的宝贵意见我们意见收到",Toast.LENGTH_LONG).show();
            }
        });
    }
}
