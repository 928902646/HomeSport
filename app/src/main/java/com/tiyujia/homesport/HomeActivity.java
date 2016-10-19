package com.tiyujia.homesport;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends ImmersiveActivity implements View.OnClickListener{
    private final static int INFO = 0;
    private final static int STAND = 1;
    private final static int PACK = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onClick(View v) {

    }
}
