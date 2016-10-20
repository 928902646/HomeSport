package com.tiyujia.homesport.common.active.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.entity.ActiveLiveEntity;
import com.tiyujia.homesport.util.PicassoUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqybyb19860112 on 2016/10/19.
 */

public class ActiveLiveAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ActiveLiveEntity> list;
    public ActiveLiveAdapter(Context context,List<ActiveLiveEntity> list){
        if (list.size()==0){
            this.list=new ArrayList<>();
        }else {
            this.list=list;
        }
        this.context=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recylerview_active, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        viewItem.setLayoutParams(lp);
        return new ActiveLiveViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ActiveLiveViewHolder viewHolder= (ActiveLiveViewHolder) holder;
        ActiveLiveEntity entity=list.get(position);
        int type=entity.getType();
        switch (type){
            case 1:
                viewHolder.tvItemLiveType.setText("约战");
                break;
            case 2:
                viewHolder.tvItemLiveType.setText("约伴");
                break;
        }
        if (position==list.size()-1){
            viewHolder.itemView.setPadding(0,0,0,0);
        }else {
            viewHolder.itemView.setPadding(0,0,24,0);
        }
        viewHolder.tvItemActiveLive.setText(entity.getTitle());
        Picasso.with(context).load(Integer.valueOf(entity.getBmpUrl())).into(viewHolder.ivItemActiveLive);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ActiveLiveViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemActiveLive;
        TextView tvItemActiveLive,tvItemLiveType;

        public ActiveLiveViewHolder(View itemView) {
            super(itemView);
            ivItemActiveLive = (ImageView) itemView.findViewById(R.id.ivItemActiveLive);
            tvItemActiveLive = (TextView) itemView.findViewById(R.id.tvItemActiveLive);
            tvItemLiveType = (TextView) itemView.findViewById(R.id.tvItemLiveType);
        }
    }
}
