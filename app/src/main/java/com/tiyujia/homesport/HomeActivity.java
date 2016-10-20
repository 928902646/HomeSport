package com.tiyujia.homesport;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tiyujia.homesport.common.active.fragment.ActiveFragment;
import com.tiyujia.homesport.common.community.fragment.CommunityFragment;
import com.tiyujia.homesport.common.concern.fragment.ConcernFragment;
import com.tiyujia.homesport.common.personal.fragment.PersonalFragment;
import com.tiyujia.homesport.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends FragmentActivity implements View.OnClickListener{
    private final static int ACTIVE = 0;
    private final static int COMMUNITY = 1;
    private final static int CONCERN = 2;
    private final static int PERSONAL = 3;
    private int currentTabIndex = 0; // 当前tab下标
    private CustomViewPager pager;
    private TextView tvAddress,tvTitle;
    private ImageView ivSearch;
    private Button tabActivie,tabCommunity,tabConcern,tabPersonal;
    List<Fragment> fragmentList;
    ActiveFragment activeFragment=null;
    CommunityFragment communityFragment=null;
    ConcernFragment concernFragment=null;
    PersonalFragment personalFragment=null;
    private String token,id;
    private RelativeLayout relative;
    private ImageView ivAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setview();
        if(savedInstanceState!=null){
            if (fragmentList != null && fragmentList.size() > 0) {
                boolean showFlag = false;
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                for (int i = fragmentList.size() - 1; i >= 0; i--) {
                    Fragment fragment = fragmentList.get(i);
                    if (fragment != null) {
                        if (!showFlag) {
                            ft.show(fragmentList.get(i));
                            showFlag = true;
                        } else {
                            ft.hide(fragmentList.get(i));
                        }
                    }
                }
                ft.commit();
            }
        }
        tvTitle.setText("活动");
        setTabSelection(ACTIVE);// 设置默认选中的tab页
        SharedPreferences share = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        token = share.getString("Token",null);
        id = share.getString("UserId","");
    }
    /**
     * 连按两次返回
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            Dialog dialog = new AlertDialog.Builder(this)
                    .setTitle("确认退出")
                    .setIcon(R.mipmap.timg)
                    .setMessage("请您选择是否退出系统？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            HomeActivity.this.finish();
                        }
                    }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create();
            dialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //land
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //port
        }
    }
    private void setview() {
        tvAddress=(TextView)findViewById(R.id.home_address);
        ivSearch=(ImageView)findViewById(R.id.home_search);
        tvTitle=(TextView)findViewById(R.id.home_title);
        pager=(CustomViewPager)findViewById(R.id.home_viewpager);
        tabActivie=(Button)findViewById(R.id.tab_active_btn);
        tabCommunity=(Button)findViewById(R.id.tab_community_btn);
        tabConcern=(Button)findViewById(R.id.tab_concern_btn);
        tabPersonal=(Button)findViewById(R.id.tab_personal_btn);
        ivAdd=(ImageView)findViewById(R.id.home_add);
        relative=(RelativeLayout) findViewById(R.id.relative);
        tabActivie.setOnClickListener(this);
        tabCommunity.setOnClickListener(this);
        tabConcern.setOnClickListener(this);
        tabPersonal.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        pager.addOnPageChangeListener(new HomeViewPagerListener());
        fragmentList = new ArrayList<Fragment>();
        activeFragment=new ActiveFragment();
        communityFragment=new CommunityFragment();
        concernFragment=new ConcernFragment();
        personalFragment=new PersonalFragment();
        fragmentList.add(activeFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(concernFragment);
        fragmentList.add(personalFragment);
        FragmentPagerAdapter fragmentPagerAdapter = new HomeFragmentPagerAdapter(this.getSupportFragmentManager(), fragmentList);
        pager.setAdapter(fragmentPagerAdapter);
        pager.setOffscreenPageLimit(fragmentList.size());
        pager.setSlide(false);
    }


    /**
     * note:   Adapter
     * Create : Cymbi 2016/10/19 14:54
     * email:928902646@qq.com
     */
    private class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;
        public HomeFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }
    private class HomeViewPagerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int position) {
        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            setTabSelection(position);
        }
    }
    /**
     * 根据传入的index参数来设置选中的tab页
     */
    private void setTabSelection(int index) {
        // 重置状态
        resetState();
        switch (index) {
            case ACTIVE: {  // 活动
                tabActivie.setTextColor(this.getResources().getColor(R.color.home_tab_pressed_color));
                tabActivie.setSelected(true);
                break;
            }
            case COMMUNITY: { // 社区
                tabCommunity.setTextColor(this.getResources().getColor(R.color.home_tab_pressed_color));
                tabCommunity.setSelected(true);
                break;
            }
            case CONCERN: {  //关注
                tabConcern.setTextColor(this.getResources().getColor(R.color.home_tab_pressed_color));
                tabConcern.setSelected(true);
                break;
            }
            case PERSONAL: {  // 我的
                tabPersonal.setTextColor(this.getResources().getColor(R.color.home_tab_pressed_color));
                tabPersonal.setSelected(true);
                break;
            }
        }
        pager.setCurrentItem(index, false);
        currentTabIndex = index;
    }
    /**
     * 重置状态
     */
    private void resetState() {
        tabActivie.setTextColor(this.getResources().getColor(R.color.home_tab_nor_color));
        tabActivie.setSelected(false);
        tabCommunity.setTextColor(this.getResources().getColor(R.color.home_tab_nor_color));
        tabCommunity.setSelected(false);
        tabConcern.setTextColor(this.getResources().getColor(R.color.home_tab_nor_color));
        tabConcern.setSelected(false);
        tabPersonal.setTextColor(this.getResources().getColor(R.color.home_tab_nor_color));
        tabPersonal.setSelected(false);
    }
    @Override
    public void onBackPressed() {//back to home
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_active_btn:
                setTabSelection(ACTIVE);
                tvTitle.setText("活动");
                ivAdd.setVisibility(View.GONE);
                ivSearch.setVisibility(View.VISIBLE);
                relative.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_community_btn:
                setTabSelection(COMMUNITY);
                tvTitle.setText("社区");
                ivAdd.setVisibility(View.GONE);
                ivSearch.setVisibility(View.GONE);
                relative.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_concern_btn:
                setTabSelection(CONCERN);
                tvTitle.setText("我的关注");
                tvAddress.setVisibility(View.GONE);
                ivAdd.setVisibility(View.VISIBLE);
                ivSearch.setVisibility(View.VISIBLE);
                relative.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_personal_btn:
                setTabSelection(PERSONAL);
                relative.setVisibility(View.GONE);
                break;
            case R.id.home_add:
                Toast.makeText(this,"点了",Toast.LENGTH_SHORT).show();
                break;
            default:
                setTabSelection(ACTIVE);
        }
    }
}
