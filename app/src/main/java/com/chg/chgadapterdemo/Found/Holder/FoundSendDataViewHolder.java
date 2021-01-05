package com.chg.chgadapterdemo.Found.Holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chg.CHGAdapter.Adapter;
import com.chg.CHGAdapter.CHGRecyclerView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FoundSendData;
import com.chg.chgadapterdemo.Found.Model.FoundUser;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FoundSendDataViewHolder extends ViewHolder<FoundSendData> {

    private TextView content;
    private CHGRecyclerView chgRecyclerView;
    private ImageView headImageView;
    private TextView nickname;
    private TextView remark;
    private TextView browses;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    public FoundSendDataViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener, ViewGroup parent) {
        super(itemView, eventTransmissionListener, parent);
    }

    @Override
    public void onCreated() {
        content = findViewById(R.id.content);
        chgRecyclerView = findViewById(R.id.chgRecycleView);
        headImageView = findViewById(R.id.headImageView);
        nickname = findViewById(R.id.nickname);
        remark = findViewById(R.id.remark);
        browses = findViewById(R.id.browses);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
    }

    @Override
    public void onBindViewHolder(FoundSendData model) {
        super.onBindViewHolder(model);
        FoundSendData foundSendData = (FoundSendData) model;
        content.setText(foundSendData.getContent().getContent());

        List sources = foundSendData.getContent().getSource();
        if (sources != null) {
            if (sources.size() == 1) {
                chgRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
            } else if (sources.size() == 2) {
                chgRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            } else {
                chgRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            }
        }
        chgRecyclerView.setModels(sources);
        chgRecyclerView.setEventTransmissionListener(getEventTransmissionListener());
        ((Adapter) chgRecyclerView.getAdapter()).setCustomData(foundSendData);


        String url = getUrl(foundSendData.getUser().getAvatar(), 24);
        headImageView.setTag(url);

        displayImageCenter(headImageView, url, getContext(), R.drawable.lei_da, true);

        nickname.setText(foundSendData.getUser().getFinalShowName());
        remark.setText(foundSendData.getUser().getExts());
        browses.setText(foundSendData.getContent().getBrowses() + "人看过");
        setLikesView(foundSendData);
    }

    @Override
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        Glide.with(getContext()).clear(headImageView);
        headImageView.setImageResource(R.drawable.default_pic);

        Glide.with(getContext()).clear(imageView1);
        imageView1.setImageResource(R.drawable.default_pic);

        Glide.with(getContext()).clear(imageView2);
        imageView2.setImageResource(R.drawable.default_pic);

        Glide.with(getContext()).clear(imageView3);
        imageView3.setImageResource(R.drawable.default_pic);
    }

    public void setLikesView(FoundSendData foundSendData) {
        List likes = foundSendData.getLikes();
        imageView1.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);
        if (likes != null) {
            if (likes.size() == 1) {
                imageView1.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                imageView3.setVisibility(View.VISIBLE);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView3.setLayoutParams(layoutParams);

                FoundUser user1 = (FoundUser) likes.get(0);
                String url3 = getUrl(user1.getAvatar(), 24);
                imageView3.setTag(url3);
                displayImageCenter(imageView3, url3, getContext(), R.drawable.lei_da, true);
            } else if (likes.size() == 2) {
                imageView1.setVisibility(View.GONE);
                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);

                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams2.setMargins(dp2px(0), 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView2.setLayoutParams(layoutParams2);

                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
                layoutParams3.setMargins(dp2px(-10), 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView3.setLayoutParams(layoutParams3);

                FoundUser user1 = (FoundUser) likes.get(0);
                FoundUser user2 = (FoundUser) likes.get(1);

                String url3 = getUrl(user1.getAvatar(), 24);
                imageView3.setTag(url3);

                String url2 = getUrl(user1.getAvatar(), 24);
                imageView2.setTag(url3);

                displayImageCenter(imageView3, url3, getContext(), R.drawable.default_pic, true);
                displayImageCenter(imageView2, url2, getContext(), R.drawable.default_pic, true);

            } else if (likes.size() >= 3) {
                imageView1.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);

                LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) imageView1.getLayoutParams();
                layoutParams1.setMargins(0, 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView1.setLayoutParams(layoutParams1);

                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams2.setMargins(dp2px(-10), 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView2.setLayoutParams(layoutParams2);

                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
                layoutParams3.setMargins(dp2px(-10), 0, 0, 0);//4个参数按顺序分别是左上右下
                imageView3.setLayoutParams(layoutParams3);

                FoundUser user1 = (FoundUser) likes.get(0);
                FoundUser user2 = (FoundUser) likes.get(1);
                FoundUser user3 = (FoundUser) likes.get(2);




                String url3 = getUrl(user3.getAvatar(), 24);
                imageView3.setTag(url3);

                String url2 = getUrl(user2.getAvatar(), 24);
                imageView2.setTag(url2);

                String url1 = getUrl(user1.getAvatar(), 24);
                imageView1.setTag(url1);

                displayImageCenter(imageView3, url3, getContext(), R.drawable.lei_da, true);
                displayImageCenter(imageView2, url2, getContext(), R.drawable.lei_da, true);
                displayImageCenter(imageView1, url1, getContext(), R.drawable.lei_da, true);
            }
        }
    }


    public String getUrl(String url, int dp) {
        return url + "?x-oss-process=image/resize,w_" + dp2px(dp) + "/quality,q_50";
    }

    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getContext().getResources().getDisplayMetrics());
    }


    public void displayImageCenter(final ImageView imageview, final String url, Context context, int defultPic, Boolean isCircleCrop) {
        RequestOptions options = null;
        if (isCircleCrop) {
            options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).placeholder(defultPic).error(defultPic).dontAnimate().circleCropTransform();
        } else {
            options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).placeholder(defultPic).error(defultPic).dontAnimate();
        }

        Glide.with(context).load(url).apply(options).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                if (imageview != null) {
                    String urlT = (String) imageview.getTag();
                    if (drawable != null && urlT != null && urlT.equals(url)) {
                        imageview.setImageDrawable(drawable);
                    }
                }
            }
        });
    }
}
