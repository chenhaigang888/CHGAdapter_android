package com.chg.CHGAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装的ViewHolder类
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder {

    private EventTransmissionListener eventTransmissionListener;
    private ViewGroup parent;
    private Model model;
//    private int itemPosition;

    public ViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView);
        this.eventTransmissionListener = eventTransmissionListener;
    }


    public Context getContext() {
        return itemView.getContext();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    @Nullable
    public final <T extends View> T findViewById(@IdRes int id) {
        return itemView.findViewById(id);
    }


    public ViewGroup getParent() {
        return parent;
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    /**
     * 获取用户自定义的对象
     *
     * @return
     */
    public Object getCustomData() {
        return getAdapter().getCustomData();
    }

    public Adapter getAdapter() {
        return (Adapter) ((RecyclerView) getParent()).getAdapter();
    }

    /**
     * 绑定数据
     *
     * @param model 具体的数据
     */
    public void onBindViewHolder(Model model) {
        this.model = model;
    }

    /**
     * 将要显示
     */
    public void onViewAttachedToWindow() {

    }

    /**
     * 不在显示
     */
    public void onViewDetachedFromWindow() {

    }


    /**
     * 即将销毁
     */
    public void onViewRecycled() {

    }
}
