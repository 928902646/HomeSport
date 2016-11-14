package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.adapter.PersonalActiveAdapter;
import com.tiyujia.homesport.common.personal.fragment.AttendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 作者: Cymbi on 2016/11/10 17:59.
 * 邮箱:928902646@qq.com
 */

public class PersonalActive extends ImmersiveActivity  {
    @Bind(R.id.personal_back)
    ImageView personal_back;
    @Bind(R.id.personal_tab)
    TabLayout tab;
    @Bind(R.id.personal_vp)
    ViewPager vp;
    private List<String> mTitle=new ArrayList<String>();
    private List<Fragment> mFragment = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_active);
        setview();
        PersonalActiveAdapter adapter=new PersonalActiveAdapter(getSupportFragmentManager(),mFragment,mTitle);
        vp.setAdapter(adapter);
        //tablayout和viewpager关联
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(adapter);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }

    private void setview() {
        personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitle.add("我参加的");
        mTitle.add("我发起的");
        mFragment.add(new AttendFragment());
        mFragment.add(new AttendFragment());
    }


}
