package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.entity.ActiveModel;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * 作者: Cymbi on 2016/11/15 11:50.
 * 邮箱:928902646@qq.com
 */

public class PersonalFans extends ImmersiveActivity {
    @Bind(R.id.personal_back)ImageView personal_back;
    @Bind(R.id.iv_search) ImageView iv_search;
    @Bind(R.id.srlRefresh)SwipeRefreshLayout swipeRefresh;
    @Bind(R.id.recyclerView)RecyclerView recycle;
    @Bind(R.id.tv_title)TextView tv_title;
    private ArrayList<ActiveModel> mDatas;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
