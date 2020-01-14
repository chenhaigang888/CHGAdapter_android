package com.chg.chgadapterdemo.demo.Holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.R;


public class BannerItemViewHolder extends ViewHolder {

    ImageView imageView;

    public BannerItemViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        imageView = itemView.findViewById(R.id.imageView);
    }


    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol, final int position) {

    }
}
