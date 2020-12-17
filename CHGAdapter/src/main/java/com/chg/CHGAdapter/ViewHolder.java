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
public class ViewHolder<M extends Model> extends RecyclerView.ViewHolder implements ViewHolderLifeCycle<M> {

    private EventTransmissionListener eventTransmissionListener;
    private ViewGroup parent;
    private M model;

    public ViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView);
        this.eventTransmissionListener = eventTransmissionListener;
    }


    public Context getContext() {
        return itemView.getContext();
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
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

    @Override
    public void onBindViewHolder(M model) {
        this.model = model;
    }

    @Override
    public void onViewAttachedToWindow() {

    }

    @Override
    public void onViewDetachedFromWindow() {

    }

    @Override
    public void onViewRecycled() {

    }

}
