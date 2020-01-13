package com.chg.chgadapterdemo.Found.Holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chg.CHGAdapter.Adapter;
import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FoundSendData;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FoundSendDataViewHolder extends ViewHolder {

    private TextView content;
    private CHGRecycleView chgRecycleView;
    private ImageView headImageView;
    private TextView nickname;
    private TextView remark;
    private TextView browses;

    public FoundSendDataViewHolder(View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        content = findViewById(R.id.content);
        chgRecycleView = findViewById(R.id.chgRecycleView);
        headImageView = findViewById(R.id.headImageView);
        nickname = findViewById(R.id.nickname);
        remark = findViewById(R.id.remark);
        browses = findViewById(R.id.browses);
    }

    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol) {
        FoundSendData foundSendData = (FoundSendData) modelProtocol;
        content.setText(foundSendData.getContent().getContent());
        List sources = foundSendData.getContent().getSource();
        if (sources != null) {
            if (sources.size() == 1) {
                chgRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 1));
            } else if (sources.size() == 2) {
                chgRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            } else {
                chgRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            }
        }
        chgRecycleView.setData(sources);
        chgRecycleView.setEventTransmissionListener(getEventTransmissionListener());
        ((Adapter) chgRecycleView.getAdapter()).setCustomData(foundSendData);

        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false);//不做内存缓存

        Glide.with(getItemView()).load(foundSendData.getUser().getAvatar()).apply(mRequestOptions).into(headImageView);
        nickname.setText(foundSendData.getUser().getFinalShowName());
        remark.setText(foundSendData.getUser().getExts());
        browses.setText(foundSendData.getContent().getBrowses() + "人看过");
    }
}
