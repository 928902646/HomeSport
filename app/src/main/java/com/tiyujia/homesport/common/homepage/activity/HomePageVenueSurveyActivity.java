package com.tiyujia.homesport.common.homepage.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.tiyujia.homesport.ImmersiveActivity;
import com.tiyujia.homesport.R;

public class HomePageVenueSurveyActivity extends ImmersiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_home_page_venue_survey);
    }
}
