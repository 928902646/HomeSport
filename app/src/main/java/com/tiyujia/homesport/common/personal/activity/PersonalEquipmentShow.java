package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.adapter.dynamicadapter;
import com.tiyujia.homesport.entity.ActiveModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: Cymbi on 2016/11/14 17:45.
 * 邮箱:928902646@qq.com
 */

public class PersonalEquipmentShow extends ImmersiveActivity {
    @Bind(R.id.personal_back)
    ImageView personal_back;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    private ArrayList<ActiveModel> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_equipment_show);
        ButterKnife.bind(this);
        personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initdata();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycle.setLayoutManager(layoutManager);
        recycle.setAdapter(new dynamicadapter(this,mDatas));

    }

    private void initdata() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            ActiveModel activeModel=  new ActiveModel();
            mDatas.add(activeModel);
        }
    }
}
