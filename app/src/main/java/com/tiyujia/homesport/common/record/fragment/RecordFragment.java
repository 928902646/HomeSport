package com.tiyujia.homesport.common.record.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiyujia.homesport.BaseFragment;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.record.activity.RecordTopActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zzqybyb19860112 on 2016/10/18.
 */
public class RecordFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private TextView tvTop,tvRecord;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.record_fragment,null);
        return view;
    }

    @Override
    protected void initData() {
        tvTop=(TextView)view.findViewById(R.id.tvTop);
        tvRecord=(TextView)view.findViewById(R.id.tvRecord);
        tvTop.setOnClickListener(this);
        tvRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvTop:
            getActivity().startActivity(new Intent(getActivity(),RecordTopActivity.class));
                break;
            case R.id.tvRecord:

                break;
        }
    }
}
