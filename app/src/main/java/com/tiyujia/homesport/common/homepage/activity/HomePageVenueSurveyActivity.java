package com.tiyujia.homesport.common.homepage.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.homepage.fragment.AllVenueFragment;
import com.tiyujia.homesport.common.personal.fragment.AttendFragment;
import com.tiyujia.homesport.widget.TablayoutVPAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;

public class HomePageVenueSurveyActivity extends ImmersiveActivity implements View.OnClickListener{
    @Bind(R.id.tab)    TabLayout tab;
    @Bind(R.id.vp)     ViewPager vp;
    private List<String> mTitle=new ArrayList<String>();
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    @Bind(R.id.ivVenueSurveySearch) ImageView ivVenueSurveySearch;
    @Bind(R.id.ivVenueSurveyClose) ImageView ivVenueSurveyClose;
    @Bind(R.id.rlStartSearch) RelativeLayout rlStartSearch;
    @Bind(R.id.rlEndSearch) RelativeLayout rlEndSearch;
    private static EditText etVenueSearch;
    AllVenueFragment allVenueFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_venue_survey);
        etVenueSearch= (EditText) findViewById(R.id.etVenueSearch);
        setView();
        TablayoutVPAdapter adapter=new TablayoutVPAdapter(getSupportFragmentManager(),mFragments,mTitle);
        vp.setAdapter(adapter);
        //tablayout和viewpager关联
        tab.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(4);
        tab.setTabsFromPagerAdapter(adapter);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setTabMode(TabLayout.MODE_FIXED);
        setListeners();
    }
    private void setListeners() {
        ivVenueSurveyClose.setOnClickListener(this);
        ivVenueSurveySearch.setOnClickListener(this);
        etVenueSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                allVenueFragment.adapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void setView() {
        mTitle.add("全部");
        mTitle.add("离我最近");
        mTitle.add("最热门");
        mTitle.add("难度最大");
        allVenueFragment=new AllVenueFragment();
        mFragments.add(allVenueFragment);
        mFragments.add(new AttendFragment());
        mFragments.add(new AttendFragment());
        mFragments.add(new AttendFragment());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivVenueSurveySearch:
                rlEndSearch.setVisibility(View.VISIBLE);
                rlStartSearch.setVisibility(View.GONE);
                break;
            case R.id.ivVenueSurveyClose:
                rlStartSearch.setVisibility(View.VISIBLE);
                rlEndSearch.setVisibility(View.GONE);
                break;
        }
    }
    public static String getSearchText(){
        return etVenueSearch.getText().toString().trim().equals("")?"":etVenueSearch.getText().toString().trim();
    }
}
