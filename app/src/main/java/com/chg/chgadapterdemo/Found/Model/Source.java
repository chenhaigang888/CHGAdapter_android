package com.chg.chgadapterdemo.Found.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Found.Holder.SourceViewHolder;
import com.chg.chgadapterdemo.R;

import java.io.Serializable;

public class Source implements ModelProtocol , Serializable {
    private Integer sourceType;
    private String url;
    private float height;
    private float width;
    private String path;
    private Float duration;
    private Boolean isLongImage;

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
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
    public int getResource(ViewGroup parent, int position) {
        return R.layout.source_item;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return SourceViewHolder.class;
    }
}
