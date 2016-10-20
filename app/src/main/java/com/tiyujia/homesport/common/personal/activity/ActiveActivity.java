package com.tiyujia.homesport.common.personal.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.personal.adapter.ActiveAdapter;
import com.tiyujia.homesport.common.personal.fragment.AttendFragment;
import com.tiyujia.homesport.common.personal.fragment.IssueFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: Cymbi on 2016/10/20 16:41.
 * 邮箱:928902646@qq.com
 */

public class ActiveActivity extends ImmersiveActivity implements View.OnClickListener{
    private ImageView ivBack;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<String> mTitle=new ArrayList<String>();
    private List<Fragment> mFragment = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_activity);
        setview();
        initview();
        ActiveAdapter adapter = new ActiveAdapter(getSupportFragmentManager(), mFragment, mTitle);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(2);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabsFromPagerAdapter(adapter);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
    }
    private void initview() {
        mTitle.add("我参加的");
        mTitle.add("我发起的");
        mFragment.add(new AttendFragment());
        mFragment.add(new IssueFragment());
    }

    private void setview() {
        ivBack=(ImageView)findViewById(R.id.ivBack);
        tablayout=(TabLayout)findViewById(R.id.tablayout);
        viewpager=(ViewPager)findViewById(R.id.viewpager);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                finish();
                break;
        }
    }
}
