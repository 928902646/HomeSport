package com.tiyujia.homesport.common.personal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiyujia.homesport.BaseFragment;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.adapter.testadapter;
import com.tiyujia.homesport.entity.ActiveModel;

import java.util.ArrayList;

/**
 * 作者: Cymbi on 2016/10/20 16:51.
 * 邮箱:928902646@qq.com
 */

public class AttendFragment extends BaseFragment {
    private View view;
    private RecyclerView recycle;
    private SwipeRefreshLayout swipeRefresh;
    private ArrayList<ActiveModel> mDatas;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.recycleview_layout,null);
        return view;
    }

    @Override
    protected void initData() {
        initdata();
        recycle= (RecyclerView)view.findViewById(R.id.recycle);
        swipeRefresh= (SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(layoutManager);
        recycle.setAdapter(new testadapter(getActivity(),mDatas));
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
