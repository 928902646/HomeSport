package com.tiyujia.homesport.common.homepage.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.widget.TablayoutVPAdapter;
import com.tiyujia.homesport.common.personal.fragment.AttendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class HomePageVenueSurveyActivity extends ImmersiveActivity {
    @Bind(R.id.tab)    TabLayout tab;
    @Bind(R.id.vp)     ViewPager vp;
    private List<String> mTitle=new ArrayList<String>();
    private List<Fragment> mFragment = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_venue_survey);
        setView();
        TablayoutVPAdapter adapter=new TablayoutVPAdapter(getSupportFragmentManager(),mFragment,mTitle);
        vp.setAdapter(adapter);
        //tablayout和viewpager关联
        tab.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(4);
        tab.setTabsFromPagerAdapter(adapter);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }
    private void setView() {
        mTitle.add("全部");
        mTitle.add("离我最近");
        mTitle.add("最热门");
        mTitle.add("难度最大");
        mFragment.add(new AttendFragment());
        mFragment.add(new AttendFragment());
        mFragment.add(new AttendFragment());
        mFragment.add(new AttendFragment());
    }
}
