package com.chg.chgadapterdemo.Found.Holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FoundSendData;
import com.chg.chgadapterdemo.Found.Model.Source;
import com.chg.chgadapterdemo.R;

import java.util.HashMap;

public class SourceViewHolder extends ViewHolder {

    private ImageView imageView;

    public SourceViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        imageView = findViewById(R.id.imageView);
    }

    //获取图片url
    public String getUrl(ModelProtocol modelProtocol, int imageWidth) {
        String url = null;
        if (getCustomData() != null) {
            final FoundSendData foundSendData = (FoundSendData) getCustomData();
            Integer type = foundSendData.getContent().getType();
            if (type == 2) {//图片
                Log.i("chg", "图片");
                Source source = (Source) modelProtocol;
                url = source.getUrl() + "?x-oss-process=image/resize,w_" + imageWidth + "/quality,q_50";
            } else if (type == 3) {//视频
                url = foundSendData.getContent().getCover();
                Log.i("chg", "视频");
            }
        } else {
            Source source = (Source) modelProtocol;
            url = source.getUrl() + "?x-oss-process=image/resize,w_" + imageWidth + "/quality,q_50";
        }

        return url;
    }

    //获取图片的宽高
    public int getPicWidth(ModelProtocol modelProtocol) {
        int imageWidth = 0;
        int viewWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        int viewHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        Source source = (Source) modelProtocol;
        if (getCustomData() != null) {
            final FoundSendData foundSendData = (FoundSendData) getCustomData();
            if (foundSendData.getContent().getSource() != null && foundSendData.getContent().getSource().size() > 0) {
                int size = foundSendData.getContent().getSource().size();
                if (size == 1) {
                    if (source.getHeight() == 0 || source.getWidth() == 0) {

                        imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth, viewWidth));
                        imageWidth = viewWidth;
                    } else {
                        int height = (int) (source.getWidth() / source.getHeight() * viewWidth);
                        height = height >= viewHeight ? (int) (viewHeight * 0.7) : height;
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth, height));
                        imageWidth = viewWidth;
                    }
                } else if (size == 2) {
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth / 2, viewWidth / 2));
                    imageWidth = viewWidth / 2;
                } else {
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth / 3, viewWidth / 3));
                    imageWidth = viewWidth / 3;
                }
            }
        } else {
            imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth, viewHeight));
            imageWidth = viewWidth;
        }

        imageWidth = imageWidth > 900 ? 900 : imageWidth;
        return imageWidth;
    }

    @Override
    public void onBindViewHolder(final ModelProtocol modelProtocol, final int position) {
        String url = getUrl(modelProtocol, getPicWidth(modelProtocol));
        Log.i("chg", "图片链接：" + url);
        Glide.with(itemView).load(url).into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCustomData() != null) {
                    final FoundSendData foundSendData = (FoundSendData) getCustomData();
                    HashMap map = new HashMap();
                    map.put("position", position);
                    map.put("sources", foundSendData.getContent().getSource());
                    getEventTransmissionListener().onEventTransmission(this, map, 0, null);
                } else {
                    getEventTransmissionListener().onEventTransmission(this, modelProtocol, 0, null);
                }
            }
        });
    }


}
