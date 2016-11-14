package com.tiyujia.homesport.common.personal.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiyujia.homesport.R;
import com.tiyujia.homesport.util.RefreshUtil;

import java.util.List;

/**
 * 作者: Cymbi on 2016/10/20 16:51.
 * 邮箱:928902646@qq.com
 */

public class AttendFragment extends Fragment {
    private View view;
    private RecyclerView recycle;
    private SwipeRefreshLayout swipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.recycleview_layout,null);
        setview();
        return view;
    }

    private void setview() {
        recycle= (RecyclerView)view.findViewById(R.id.recycle);
        swipeRefresh= (SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);
        RefreshUtil.refresh(swipeRefresh,getActivity());
    }

}
