package com.tiyujia.homesport.common.active.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.active.adapter.ActiveLiveAdapter;
import com.tiyujia.homesport.common.active.adapter.GridViewActiveAdapter;
import com.tiyujia.homesport.common.active.adapter.ViewPagerActiveAdapter;
import com.tiyujia.homesport.entity.ActiveEntity;
import com.tiyujia.homesport.entity.ActiveLiveEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqybyb19860112 on 2016/10/18.1111222
 */
public class ActiveFragment extends Fragment {
    private View view;
    private String[] titles = {"美食", "电影", "酒店住宿", "休闲娱乐", "外卖", "自助餐", "KTV", "机票/火车票", "周边游", "美甲美睫",
            "火锅", "生日蛋糕", "甜品饮品", "水上乐园", "汽车服务", "美发"};
    private int[] bmpUrls={R.mipmap.demo_0,R.mipmap.demo_1,R.mipmap.demo_2,R.mipmap.demo_3,R.mipmap.demo_4,R.mipmap.demo_5,R.mipmap.demo_6,R.mipmap.demo_7,
            R.mipmap.demo_8,R.mipmap.demo_9,R.mipmap.demo_10,R.mipmap.demo_11,R.mipmap.demo_12,R.mipmap.demo_13,R.mipmap.demo_14,R.mipmap.demo_15};
    private ViewPager mPager;
    private List<View> mPagerList;
    private List<ActiveEntity> mDatas;
    private List<ActiveLiveEntity> activeLiveEntities;
    private LinearLayout mLlDot;
    private LayoutInflater inflater;
    private RecyclerView rvActiveLive;
    private ActiveLiveAdapter liveAdapter;
    /**
     * 总的页数
     */
    private int pageCount;
    /**
     * 每一页显示的个数
     */
    private int pageSize = 8;
    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;
    public static final int HANDLE_DATA_READY=1;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case HANDLE_DATA_READY:
                    liveAdapter=new ActiveLiveAdapter(getActivity(),activeLiveEntities);
                    RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                    rvActiveLive.setLayoutManager(manager);
                    rvActiveLive.setAdapter(liveAdapter);
                    break;
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.active_fragment,null);
        mPager = (ViewPager) view.findViewById(R.id.vpActive);
        mLlDot = (LinearLayout) view.findViewById(R.id.ll_dot);
        rvActiveLive = (RecyclerView) view.findViewById(R.id.rvActiveLive);
        //初始化数据源
        initDatas();
        this.inflater = LayoutInflater.from(getActivity());
        //总的页数=总数/每页数量，并取整
        pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
        mPagerList = new ArrayList<View>();
        for (int i = 0; i < pageCount; i++) {
            //每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview_active, mPager, false);
            gridView.setAdapter(new GridViewActiveAdapter(getActivity(), mDatas, i, pageSize));
            mPagerList.add(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pos = position + curIndex * pageSize;
                    Toast.makeText(getActivity(), mDatas.get(pos).getTitle(), Toast.LENGTH_SHORT).show();//----------------设置点击事件---------------------
                }
            });
        }
        //设置适配器
        mPager.setAdapter(new ViewPagerActiveAdapter(mPagerList));
        //设置圆点
        setOvalLayout();
        return view;
    }
    /**
     * 初始化数据源
     */
    private void initDatas() {
        mDatas = new ArrayList<ActiveEntity>();
        for (int i = 0; i < titles.length; i++) {
            //动态获取资源ID，第一个参数是资源名，第二个参数是资源类型例如drawable，string等，第三个参数包名
            mDatas.add(new ActiveEntity(titles[i], bmpUrls[i]+""));
        }
        activeLiveEntities=new ArrayList<>();
        for (int i=0;i<5;i++){
            ActiveLiveEntity entity=new ActiveLiveEntity();
            entity.setType(i%2);
            entity.setBmpUrl(bmpUrls[i]+"");
            entity.setTitle("就测试一下，第"+i+"次");
            activeLiveEntities.add(entity);
        }
        handler.sendEmptyMessage(HANDLE_DATA_READY);
    }

    /**
     * 设置圆点
     */
    public void setOvalLayout() {
        for (int i = 0; i < pageCount; i++) {
            mLlDot.addView(inflater.inflate(R.layout.dot, null));
        }
        // 默认显示第一页
        mLlDot.getChildAt(0).findViewById(R.id.v_dot)
                .setBackgroundResource(R.drawable.dot_selected);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                // 取消圆点选中
                mLlDot.getChildAt(curIndex)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_normal);
                // 圆点选中
                mLlDot.getChildAt(position)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_selected);
                curIndex = position;
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
}
