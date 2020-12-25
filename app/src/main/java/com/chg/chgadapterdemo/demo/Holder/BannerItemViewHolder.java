package com.chg.chgadapterdemo.demo.Holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.Model;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.R;


public class BannerItemViewHolder extends ViewHolder {

    ImageView imageView;

    public BannerItemViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener, ViewGroup parent) {
        super(itemView, eventTransmissionListener, parent);
        imageView = itemView.findViewById(R.id.imageView);
    }


    @Override
    public void onBindViewHolder(Model modelProtocol) {

    }
}
