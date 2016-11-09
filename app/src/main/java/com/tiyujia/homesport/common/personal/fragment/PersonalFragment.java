package com.tiyujia.homesport.common.personal.fragment;

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
public class PersonalFragment extends Fragment implements View.OnClickListener{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.personal_fragment,null);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
