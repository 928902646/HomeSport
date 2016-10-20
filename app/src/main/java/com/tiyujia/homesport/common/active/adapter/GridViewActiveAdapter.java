package com.tiyujia.homesport.common.active.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.tiyujia.homesport.R;
import com.tiyujia.homesport.entity.ActiveEntity;
import com.tiyujia.homesport.util.PicassoUtil;

import java.util.List;

/**
 * Created by zzqybyb19860112 on 2016/10/19.
 */

public class GridViewActiveAdapter extends BaseAdapter {
    private Context context;
    private List<ActiveEntity> mDatas;
    private LayoutInflater inflater;
    /**
     * 页数下标,从0开始(当前是第几页)
     */
    private int curIndex;
    /**
     * 每一页显示的个数
     */
    private int pageSize;

    public GridViewActiveAdapter(Context context, List<ActiveEntity> mDatas, int curIndex, int pageSize) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
        this.curIndex = curIndex;
        this.pageSize = pageSize;
    }

    /**
     * 先判断数据集的大小是否足够显示满本页？mDatas.size() > (curIndex+1)*pageSize,
     * 如果够，则直接返回每一页显示的最大条目个数pageSize,
     * 如果不够，则有几项返回几,(mDatas.size() - curIndex * pageSize);(也就是最后一页的时候就显示剩余item)
     */
    @Override
    public int getCount() {
        return mDatas.size() > (curIndex + 1) * pageSize ? pageSize : (mDatas.size() - curIndex * pageSize);

    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position + curIndex * pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex * pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gridview_active, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvItemActive = (TextView) convertView.findViewById(R.id.tvItemActive);
            viewHolder.ivItemActive = (ImageView) convertView.findViewById(R.id.ivItemActive);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        /**
         * 在给View绑定显示的数据时，计算正确的position = position + curIndex * pageSize，
         */
        int pos = position + curIndex * pageSize;
        viewHolder.tvItemActive.setText(mDatas.get(pos).getTitle());
        Picasso.with(context).load(Integer.valueOf(mDatas.get(pos).getPicUrl())).into(viewHolder.ivItemActive);
        return convertView;
    }
    class ViewHolder {
        public TextView tvItemActive;
        public ImageView ivItemActive;
    }
}