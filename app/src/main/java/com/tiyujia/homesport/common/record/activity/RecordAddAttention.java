package com.tiyujia.homesport.common.record.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.record.adapter.AddAttentionAdapter;
import com.tiyujia.homesport.entity.ActiveModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: Cymbi on 2016/11/16 17:38.
 * 邮箱:928902646@qq.com
 */

public class RecordAddAttention extends ImmersiveActivity implements View.OnClickListener ,SwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.personal_back)ImageView personal_back;
    @Bind(R.id.iv_search) ImageView iv_search;
    @Bind(R.id.srlRefresh)SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.recyclerView)RecyclerView recycle;
    @Bind(R.id.tv_title)TextView tv_title;
    @Bind(R.id.tv_tuijian)TextView tv_tuijian;
    private ArrayList<ActiveModel> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attention);
        ButterKnife.bind(this);
        initdata();
        personal_back.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycle.setLayoutManager(layoutManager);
        recycle.setAdapter(new AddAttentionAdapter(this,mDatas));
    }

    private void initdata() {
        mDatas = new ArrayList<>();
        tv_title.setText("添加关注");
        tv_tuijian.setVisibility(View.VISIBLE);
        for (int i = 0; i < 10; i++)
        {
            ActiveModel activeModel=  new ActiveModel();
            mDatas.add(activeModel);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_back:
                finish();
                break;
            case R.id.iv_search:

                break;
        }
    }

    @Override
    public void onRefresh() {

    }
}
