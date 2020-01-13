package com.chg.chgadapterdemo.Found.Holder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chg.CHGAdapter.Adapter;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FoundSendData;
import com.chg.chgadapterdemo.Found.Model.Source;
import com.chg.chgadapterdemo.R;

public class SourceViewHolder extends ViewHolder {

    private ImageView imageView;

    public SourceViewHolder(View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        imageView = itemView.findViewById(R.id.imageView);

    }

    @Override
    public void onBindViewHolder(final ModelProtocol modelProtocol) {
        Source source = (Source) modelProtocol;
        int viewWidth = getItemView().getContext().getResources().getDisplayMetrics().widthPixels;
        int viewHeight = getItemView().getContext().getResources().getDisplayMetrics().heightPixels;

        RecyclerView recyclerView = (RecyclerView) getParent();
        final Adapter adapter = (Adapter) recyclerView.getAdapter();
        int imageWidth = 0;
        if (adapter.getCustomData() != null) {
            final FoundSendData foundSendData = (FoundSendData) adapter.getCustomData();
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
            imageView.setLayoutParams(new LinearLayout.LayoutParams(viewWidth, viewWidth));
            imageWidth = viewWidth;
        }


        imageWidth = imageWidth > 900 ? 900 : imageWidth;
        String url = source.getUrl() + "?x-oss-process=image/resize,w_" + imageWidth + "/quality,q_50";
        Log.i("图片", url);
        Glide.with(getItemView()).load(url).into(imageView);

        getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getCustomData() != null) {
                    final FoundSendData foundSendData = (FoundSendData) adapter.getCustomData();
                    getEventTransmissionListener().onEventTransmission(this, foundSendData.getContent().getSource(), 0, null);
                } else {
                    getEventTransmissionListener().onEventTransmission(this, modelProtocol, 0, null);
                }

            }
        });

    }


}
