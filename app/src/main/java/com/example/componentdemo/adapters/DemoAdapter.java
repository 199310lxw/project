package com.example.componentdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.componentdemo.R;

import java.util.ArrayList;


/*************************************
 * @Author : liuxiangwang
 * @Date : 15:12  2020/9/2
 * @Email : liuxiangwang@vivo.com
 * @title :
 * @Company : www.vivo.com
 * @Description :
 ************************************/

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.BaseViewHolder> {
    private Context mContext;
    private ArrayList<Integer> dataList = new ArrayList<>();

    public DemoAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void replaceAll(ArrayList<Integer> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    /**
     * 插入数据使用notifyItemInserted，如果要使用插入动画，必须使用notifyItemInserted
     * 才会有效果。即便不需要使用插入动画，也建议使用notifyItemInserted方式添加数据，
     * 不然容易出现闪动和间距错乱的问题
     * */
    public void addData(int position,ArrayList<Integer> list) {
        dataList.addAll(position,list);
        notifyItemInserted(position);
    }

    //移除数据使用notifyItemRemoved
    public void removeData(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public DemoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_waterfall_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DemoAdapter.BaseViewHolder holder, int position) {
        holder.setData(mContext,dataList.get(position),position);
    }


    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        void setData(Context context,Object data,int position) {

        }
    }

    private class OneViewHolder extends BaseViewHolder {
        private ImageView ivImage;

        public OneViewHolder(View view) {
            super(view);
            ivImage = (ImageView) view.findViewById(R.id.iv_item_water_fall);
        }

        @Override
        void setData(Context context, Object data, int position) {
            if (data != null) {
                int id = (int) data;
                ivImage.setImageResource(id);
//                Glide.with(context).load(R.mipmap.p1).into(ivImage);
                //需要Item高度不同才能出现瀑布流的效果，此处简单粗暴地设置一下高度
                if (position % 2 == 0) {
                    ivImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 450));
                } else {
                    ivImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 550));
                }
            }
        }
    }


}
