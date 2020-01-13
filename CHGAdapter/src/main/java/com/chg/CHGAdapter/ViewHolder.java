package com.chg.CHGAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装的ViewHolder类
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder {

    private EventTransmissionListener eventTransmissionListener;
//    private View itemView;
    private ViewGroup parent;
    private int layoutResID;

    public Context getContext() {
        return itemView.getContext();
    }

    public ViewGroup getParent() {
        return parent;
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public View getItemView() {
        return itemView;
    }

    @Nullable
    public final <T extends View> T findViewById(@IdRes int id) {
        return itemView.findViewById(id);
    }

    public ViewHolder(View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView);

        this.eventTransmissionListener = eventTransmissionListener;

    }



    public void setContentView(@LayoutRes int layoutResID) {
        this.layoutResID = layoutResID;
    }

    public int getLayoutResID() {
        return layoutResID;
    }

    /**
     * 绑定数据
     *
     * @param modelProtocol model
     */
    public abstract void onBindViewHolder(ModelProtocol modelProtocol);
}
