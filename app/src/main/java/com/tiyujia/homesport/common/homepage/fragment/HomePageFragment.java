package com.tiyujia.homesport.common.homepage.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.squareup.picasso.Picasso;
import com.tiyujia.homesport.BaseFragment;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.homepage.entity.HomeBannerEntity;
import com.tiyujia.homesport.common.homepage.entity.HomePageData;
import com.tiyujia.homesport.common.homepage.net.DataManager;
import com.tiyujia.homesport.common.homepage.net.Result;
import com.tiyujia.homesport.common.homepage.service.HomePageService;
import com.tiyujia.homesport.util.PicassoUtil;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zzqybyb19860112 on 2016/10/18.4444
 */
public class HomePageFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener{
    HomePageService homePageService;
    @Bind(R.id.srlHomePage)      SwipeRefreshLayout swipeContainer;
    @Bind(R.id.cbHomePage)       ConvenientBanner cbHomePage;
    private List<HomeBannerEntity> banners = new ArrayList<>();
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homepage_fragment,null);
        ButterKnife.bind(this,view);
        homePageService = DataManager.getService(HomePageService.class);
        return view;
    }
    @Override
    protected void initData() {
        cbHomePage.setPages(new CBViewHolderCreator<ImageHolderView>() {
            @Override public ImageHolderView createHolder() {
                return new ImageHolderView();
            }
        }, banners).setPageIndicator(
                        new int[] { R.drawable.dot_normal, R.drawable.dot_selected})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        Subscription hotInfo = homePageService.getAllHotInfo().subscribeOn(Schedulers.io())//
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result<HomePageData>>() {
                    @Override public void onCompleted() {
                    }
                    @Override public void onError(Throwable e) {
                        Toast.makeText(getActivity(), "刷新失败", Toast.LENGTH_SHORT).show();
                    }
                    @Override public void onNext(Result<HomePageData> result) {
                        if (result.state == 200) {
                            refresh(result.data);
                        } else {
                            Toast.makeText(getActivity(), "诶~网络好像有问题啊", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        mCompositeSubscription.add(hotInfo);
        swipeContainer.setOnRefreshListener(this);
    }
    @Override public void onResume() {
        super.onResume();
        cbHomePage.startTurning(2500);
    }
    @Override public void onPause() {
        super.onPause();
        cbHomePage.stopTurning();
    }

    @Override
    public void onClick(View v) {

    }
    public class ImageHolderView implements Holder<HomeBannerEntity> {
        private ImageView iv;
        int pos=0;
        @Override public View createView(Context context) {
            iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            return iv;
        }
        @Override public void UpdateUI(Context context, final int position, HomeBannerEntity data) {
            pos=position;
//            Rect rect = new Rect();
//            ((Activity)context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
//            int x = rect.width();
//            PicassoUtil.handlePic(context, data.bmpUrl, iv, x, 720);
            Picasso.with(getActivity()).load(data.picAddress).into(iv);
        }
    }
    @Override public void onRefresh() {
        updateData();
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                // 停止刷新
                swipeContainer.setRefreshing(false);
            }
        }, 500); // 5秒后发送消息，停止刷新
    }
    public void updateData() {
        Subscription hotInfo = homePageService.getAllHotInfo().subscribeOn(Schedulers.io())//
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Result<HomePageData>>() {
                    @Override public void onCompleted() {
                        swipeContainer.setRefreshing(false);
                    }
                    @Override public void onError(Throwable e) {
                        swipeContainer.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新内容失败", Toast.LENGTH_SHORT).show();
                    }
                    @Override public void onNext(Result<HomePageData> result) {
                        swipeContainer.setRefreshing(false);
                        if (result.state == 200) {
                            refresh(result.data);
                        } else {
                            Toast.makeText(getActivity(), "当前网络状态不佳，请检查您的网络设置！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        mCompositeSubscription.add(hotInfo);
    }
    private void refresh(HomePageData data) {
        //banner
        int [] picAddress=new int[]{R.drawable.demo_05,R.drawable.demo_06,R.drawable.demo_09,R.drawable.demo_10};
        if (data.homeBannerEntities != null && data.homeBannerEntities.size() > 0) {
            banners.clear();
            data.homeBannerEntities.add(new HomeBannerEntity(picAddress[0]));
            data.homeBannerEntities.add(new HomeBannerEntity(picAddress[1]));
            data.homeBannerEntities.add(new HomeBannerEntity(picAddress[2]));
            data.homeBannerEntities.add(new HomeBannerEntity(picAddress[3]));
            banners.addAll(data.homeBannerEntities);
            cbHomePage.notifyDataSetChanged();
        }
    }
}
