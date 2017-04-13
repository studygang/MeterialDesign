package com.gangzi.meterialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder>{

    private static final String TAG="Picture";
    private Context mContext;
    private List<Picture>mPictureList;

    public PictureAdapter(List<Picture> pictureList) {
        mPictureList = pictureList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.picture_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Picture picture=mPictureList.get(position);
                Intent intent=new Intent(mContext,PictureActivity.class);
               intent.putExtra(PictureActivity.PICTURE_NAME,picture.getName());
               intent.putExtra(PictureActivity.PICTURE_ID,picture.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Picture pictures=mPictureList.get(position);
            holder.mTextView.setText(pictures.getName());
            Glide.with(mContext).load(pictures.getImageId()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView mCardView;
        ImageView mImageView;
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView= (CardView) itemView;
            mImageView= (ImageView) itemView.findViewById(R.id.picture_image);
            mTextView= (TextView) itemView.findViewById(R.id.picture_name);
        }
    }
}
