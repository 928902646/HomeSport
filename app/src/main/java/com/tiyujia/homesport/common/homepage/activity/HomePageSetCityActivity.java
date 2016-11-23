package com.tiyujia.homesport.common.homepage.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.tiyujia.homesport.App;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.homepage.adapter.HomePageCityAdapter;
import com.tiyujia.homesport.common.homepage.adapter.HomePageGVHotCityAdapter;
import com.tiyujia.homesport.common.homepage.customview.QuicLocationBar;
import com.tiyujia.homesport.common.homepage.dao.CityDBManager;
import com.tiyujia.homesport.common.homepage.entity.CityBean;
import com.tiyujia.homesport.common.homepage.fragment.HomePageFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class HomePageSetCityActivity extends AppCompatActivity {
    GridView gvHotCity;
    List<String> testCities;
    HomePageGVHotCityAdapter adapter;
    public static final int HANDLE_HOT_CITY=1;
    private ListView mCityLit;
    private TextView overlay;
    private TextView tvNowCity;
    private QuicLocationBar mQuicLocationBar;
    private HashMap<String, Integer> alphaIndexer;
    private ArrayList<CityBean> mCityNames;
    /**
     * a-z排序
     */
    @SuppressWarnings("rawtypes")
    Comparator comparator = new Comparator<CityBean>() {
        @Override
        public int compare(CityBean lhs, CityBean rhs) {
            String a = lhs.getNameSort().substring(0, 1);
            String b = rhs.getNameSort().substring(0, 1);
            int flag = a.compareTo(b);
            if (flag == 0) {
                return a.compareTo(b);
            } else {
                return flag;
            }
        }
    };
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case HANDLE_HOT_CITY:
                    adapter=new HomePageGVHotCityAdapter(HomePageSetCityActivity.this,testCities);
                    gvHotCity.setAdapter(adapter);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_set_city);
        gvHotCity= (GridView) findViewById(R.id.gvHotCity);
        setBaseData();
        mQuicLocationBar=(QuicLocationBar)findViewById(R.id.city_loactionbar);
        mQuicLocationBar.setOnTouchLitterChangedListener(new LetterListViewListener());
        overlay=(TextView)findViewById(R.id.city_dialog);
        tvNowCity=(TextView)findViewById(R.id.tvNowCity);
        mCityLit=(ListView) findViewById(R.id.city_list);
        mQuicLocationBar.setTextDialog(overlay);
        AMapLocationClient client= App.mLocationClient;
        AMapLocationClientOption option=new AMapLocationClientOption();
        HomePageFragment.resetOption(option);
        AMapLocationListener locationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation loc) {
                if (null != loc) {
                    //解析定位结果
                    String nowCity = loc.getCity();
                    tvNowCity.setText(nowCity);
                } else {
                    tvNowCity.setText("失败");
                }
            }
        };
        client.setLocationOption(option);
        // 启动定位
        client.startLocation();
        client.setLocationListener(locationListener);
        initList();
    }

    private void initList() {
        mCityNames=getCityNames();
        HomePageCityAdapter adapter=new HomePageCityAdapter(this,mCityNames);
        mCityLit.setAdapter(adapter);
        alphaIndexer=adapter.getCityMap();
        mCityLit.setOnItemClickListener(new CityListOnItemClick());
        gvHotCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityHot=testCities.get(position);
                Intent intent=new Intent();
                Toast.makeText(HomePageSetCityActivity.this,"您已选择城市："+cityHot,Toast.LENGTH_SHORT).show();
                intent.putExtra("SelectCity",cityHot);
                setResult(10002,intent);
                finish();
            }
        });
    }
    private ArrayList<CityBean> getCityNames() {
        CityDBManager dbManager=new CityDBManager(this);
        dbManager.openDateBase();
        dbManager.closeDatabase();
        SQLiteDatabase database=SQLiteDatabase.openOrCreateDatabase(CityDBManager.DB_PATH+"/"+CityDBManager.DB_NAME,null);
        ArrayList<CityBean>names=new ArrayList<CityBean>();
        Cursor cursor=database.rawQuery("select * from city",null);
        if(cursor.moveToFirst()){
            do{
                CityBean cityModel=new CityBean();
                cityModel.setCityName(cursor.getString(1));
                cityModel.setNameSort(cursor.getString(2).substring(0,1).toUpperCase());
                names.add(cityModel);
            }while(cursor.moveToNext());
        }
        database.close();
        Collections.sort(names, comparator);
        return names;
    }
    private class CityListOnItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3){
            CityBean cityModel=(CityBean)mCityLit.getAdapter().getItem(pos);
            Toast.makeText(HomePageSetCityActivity.this,"您已选择城市："+cityModel.getCityName(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent();
            intent.putExtra("SelectCity",cityModel.getCityName());
            setResult(10002,intent);
            finish();
        }
    }
    private class LetterListViewListener implements QuicLocationBar.OnTouchLetterChangedListener {
        @Override
        public void touchLetterChanged(String s) {
            if (alphaIndexer.get(s) != null) {
                int position=alphaIndexer.get(s);
                mCityLit.setSelection(position);
            }
        }
    }
    private void setBaseData() {
        testCities=new ArrayList<>();
        String[] cities={"成都","北京","上海","重庆","杭州","深圳","南京","合肥","济南","拉萨","西藏","南充","辽宁","长沙","天津","西安"};
        int number=15;
        for (int i=0;i<=number;i++){
            testCities.add(cities[i]);
        }
        handler.sendEmptyMessage(HANDLE_HOT_CITY);
    }
}
