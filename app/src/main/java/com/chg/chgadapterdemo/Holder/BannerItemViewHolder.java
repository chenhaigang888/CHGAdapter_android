package com.chg.chgadapterdemo.Holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chg.chgadapter.EventTransmissionListener;
import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapter.ViewHolder;
import com.chg.chgadapterdemo.R;


public class BannerItemViewHolder extends ViewHolder {

    ImageView imageView;

    public BannerItemViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        imageView = itemView.findViewById(R.id.imageView);
    }

    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol) {

    }
}
