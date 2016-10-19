package com.tiyujia.homesport.common.personal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.activity.PersonalSystemSetting;

/**
 * Created by zzqybyb19860112 on 2016/10/18.
 */
public class PersonalFragment extends Fragment implements View.OnClickListener{
    private View view;
    private ImageView ivSetting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.personal_fragment,null);
        setview();
        return view;
    }
    private void setview() {
        ivSetting=(ImageView)view.findViewById(R.id.ivSetting);
        ivSetting.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSetting:
                Intent i=new Intent(getActivity(), PersonalSystemSetting.class);
                getActivity().startActivity(i);
                break;
        }
    }
}
