package com.pity.carousels_toolbox.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pity.carousels_toolbox.R;
import com.pity.carousels_toolbox.models.CarouselItemModel;

import java.util.ArrayList;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder>{

    private final static String TAG = "RecyclerViewAdapter";


    private Context mContext;
    private ArrayList<CarouselItemModel> mList;
    private int mItemLayout;
    private final View.OnClickListener mOnClickListener;


    public CarouselAdapter(Context mContext, ArrayList<CarouselItemModel> mList, int mItemLayout, View.OnClickListener onClickListener) {
        this.mContext = mContext;
        this.mList = mList;
        this.mItemLayout = mItemLayout;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder(): called");
        View view = LayoutInflater.from(mContext).inflate(mItemLayout, parent,false);
        view.setOnClickListener(mOnClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(mList.get(position).getImageUrl())
                .into(holder.image);
        holder.title.setText(mList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;

         ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.thumb_image_view);
            title = itemView.findViewById(R.id.thumb_text_view_titulo);
        }
    }
}
