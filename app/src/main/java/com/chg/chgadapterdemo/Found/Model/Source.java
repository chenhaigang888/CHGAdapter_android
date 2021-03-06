package com.chg.chgadapterdemo.Found.Model;

import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.Found.Holder.SourceViewHolder;
import com.chg.chgadapterdemo.R;

import java.io.Serializable;

public class Source implements Model, Serializable {
    private int sourceType;
    private String url;
    //处理过的url
    private String handleUrl;
    private float height;
    private float width;
    private String path;
    private Float duration;
    private Boolean isLongImage;

    public String getHandleUrl() {
        return handleUrl;
    }

    public void setHandleUrl(String handleUrl) {
        this.handleUrl = handleUrl;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Boolean getLongImage() {
        return isLongImage;
    }

    public void setLongImage(Boolean longImage) {
        isLongImage = longImage;
    }

    @Override
    public int getResource(int position) {
        return R.layout.source_item;
    }

    @Override
    public Class getHolderClass(int position) {
        return SourceViewHolder.class;
    }
}
