package com.chg.CHGAdapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装的ViewHolder类
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder {

    private EventTransmissionListener eventTransmissionListener;
    private View itemView;

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public ViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView);
        this.itemView = itemView;
        this.eventTransmissionListener = eventTransmissionListener;
    }

    /**
     * 绑定数据
     * @param modelProtocol  model
     */
    public abstract void onBindViewHolder(ModelProtocol modelProtocol);
}
