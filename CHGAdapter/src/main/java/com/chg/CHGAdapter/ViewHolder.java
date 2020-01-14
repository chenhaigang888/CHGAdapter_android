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

    public ViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView);
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public ViewGroup getParent() {
        return parent;
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    public Context getContext() {
        return itemView.getContext();
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

    /**
     * 绑定数据
     * @param modelProtocol  具体的数据
     * @param holder
     * @param position
     */
    public abstract void onBindViewHolder(ModelProtocol modelProtocol,RecyclerView.ViewHolder holder, int position);


}
