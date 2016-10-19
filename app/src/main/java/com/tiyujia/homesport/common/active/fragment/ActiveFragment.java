package com.tiyujia.homesport.common.active.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiyujia.homesport.R;

/**
 * Created by zzqybyb19860112 on 2016/10/18.
 */
public class ActiveFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.active_fragment,null);

        return view;
    }
}
