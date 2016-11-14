package com.tiyujia.homesport.common.homepage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.common.homepage.entity.HomePageRecentVenueEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqybyb19860112 on 2016/11/11.
 */

public class HomePageRecentVenueAdapter extends RecyclerView.Adapter {
    Context context;
    List<HomePageRecentVenueEntity> values;

    public HomePageRecentVenueAdapter(Context context, List<HomePageRecentVenueEntity> values) {
        if (values.size()!=0){
            this.values = values;
        }else {
            this.values=new ArrayList<>();
        }
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_recent_venue, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewItem.setLayoutParams(lp);
        return new RecentVenueHolder(viewItem);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
      /*  RecentVenueHolder holder= (RecentVenueHolder) viewHolder;
        HomePageRecentVenueEntity data=values.get(position);
        Picasso.with(context).load(data.getBigPicUrl()).into(holder.ivPicVenue);
        holder.tvVenueName.setText(data.getVenueName());
        List<String> types=data.getVenueType();
        String typeA=types.get(0);
        String typeB=types.get(1);
        holder.tvVenueTypeA.setText(typeA);
        holder.tvVenueTypeB.setText(typeB);
        handleType(holder.tvVenueTypeA,typeA);
        int degree=data.getDegreeNumber();
        handleDegrees(degree,holder.ivDegree1,holder.ivDegree2,holder.ivDegree3,holder.ivDegree4,holder.ivDegree5);
        holder.tvGoneNumber.setText(data.getNumberGone()+"人去过");
        holder.tvTalkNumber.setText(data.getNumberTalk()+"");*/
    }

    private void handleDegrees(int degree, ImageView ivDegree1, ImageView ivDegree2, ImageView ivDegree3, ImageView ivDegree4, ImageView ivDegree5) {
        degree-=1;
        ImageView[] ivDegrees=new ImageView[]{ivDegree1,ivDegree2,ivDegree3,ivDegree4,ivDegree5};
        for (int i=0;i<5;i++){
           for (int j=0;j<=degree;j++){
               ivDegrees[j].setImageResource(R.mipmap.tab_start_s);
           }
        }
    }

    private void handleType(TextView tvVenueTypeA, String typeA) {
        if (typeA.equals("室内")){
            tvVenueTypeA.setBackgroundResource(R.drawable.border_orange);
            tvVenueTypeA.setTextColor(Color.parseColor("#ff702a"));
        }else {
            tvVenueTypeA.setBackgroundResource(R.drawable.border_blue);
            tvVenueTypeA.setTextColor(Color.parseColor("#2aa7ff"));
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    class RecentVenueHolder extends RecyclerView.ViewHolder{
        ImageView ivPicVenue,ivDegree1,ivDegree2,ivDegree3,ivDegree4,ivDegree5;
        TextView tvVenueName,tvVenueTypeA,tvVenueTypeB,tvGoneNumber,tvTalkNumber;
        public RecentVenueHolder(View itemView) {
            super(itemView);
            ivPicVenue= (ImageView) itemView.findViewById(R.id.ivPicVenue);
            ivDegree1= (ImageView) itemView.findViewById(R.id.ivDegree1);
            ivDegree2= (ImageView) itemView.findViewById(R.id.ivDegree2);
            ivDegree3= (ImageView) itemView.findViewById(R.id.ivDegree3);
            ivDegree4= (ImageView) itemView.findViewById(R.id.ivDegree4);
            ivDegree5= (ImageView) itemView.findViewById(R.id.ivDegree5);
            tvVenueName= (TextView) itemView.findViewById(R.id.tvVenueName);
            tvVenueTypeA= (TextView) itemView.findViewById(R.id.tvVenueTypeA);
            tvVenueTypeB= (TextView) itemView.findViewById(R.id.tvVenueTypeB);
            tvGoneNumber= (TextView) itemView.findViewById(R.id.tvGoneNumber);
            tvTalkNumber= (TextView) itemView.findViewById(R.id.tvTalkNumber);
        }
    }
}
