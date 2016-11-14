package com.tiyujia.homesport.util;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zzqybyb19860112 on 2016/9/4.
 */
public class InputWatcherUtil implements TextWatcher {
    private ImageView ivVenueSurveySearch,ivVenueSurveyClose;
    private RelativeLayout rlStartSearch,rlEndSearch;
    private EditText etVenueSearch;
    public InputWatcherUtil(ImageView ivVenueSurveySearch,ImageView ivVenueSurveyClose,RelativeLayout rlStartSearch,RelativeLayout rlEndSearch,EditText etVenueSearch) {
        if (ivVenueSurveySearch == null || ivVenueSurveyClose == null||rlStartSearch==null||rlEndSearch==null) {
            throw new IllegalArgumentException("请确保btnClear和etContainer不为空");
        }
        this.ivVenueSurveySearch = ivVenueSurveySearch;
        this.ivVenueSurveyClose = ivVenueSurveyClose;
        this.rlStartSearch=rlStartSearch;
        this.rlEndSearch=rlEndSearch;
        this.etVenueSearch=etVenueSearch;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        if (!TextUtils.isEmpty(s)) {
//            if (mBtnClear != null) {
//                mBtnClear.setVisibility(View.VISIBLE);
//                tvConfirm.setVisibility(View.VISIBLE);
//                tvCancel.setVisibility(View.GONE);
//                mBtnClear.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (mEtContainer != null) {
//                            mEtContainer.getText().clear();
//                            mBtnClear.setVisibility(View.GONE);
//                            tvConfirm.setVisibility(View.GONE);
//                            tvCancel.setVisibility(View.VISIBLE);
//                        }
//                    }
//                });
//            }
//        } else {
//            if (mBtnClear != null) {
//                mBtnClear.setVisibility(View.GONE);
//                tvConfirm.setVisibility(View.GONE);
//                tvCancel.setVisibility(View.VISIBLE);
//            }
//        }
    }
    @Override
    public void afterTextChanged(Editable s) {
    }
}
