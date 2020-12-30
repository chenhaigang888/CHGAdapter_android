package com.chg.CHGAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装的ViewHolder类
 */
public abstract class ViewHolder<M extends Model> extends RecyclerView.ViewHolder implements ViewHolderLifeCycle<M> ,Notify{

    private EventTransmissionListener eventTransmissionListener;
    private ViewGroup parent;
    private M model;

    public ViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener, ViewGroup parent) {
        super(itemView);
        this.eventTransmissionListener = eventTransmissionListener;
        this.parent = parent;
    }

    public Context getContext() {
        return itemView.getContext();
    }
    public abstract void onCreated();
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

    public Object eventTransmission(Object target, Object params, int eventId, EventTransmissionListener.CallBack callBack){
        if (eventTransmissionListener != null) {
            return eventTransmissionListener.onEventTransmission(target,params,eventId,callBack);
        }
        return null;
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

    public void ddd(){
        getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(M model) {
        this.model = model;
    }

    @Override
    public void onBindViewHolder(@NonNull List payloads){

    };

    @Override
    public void onViewAttachedToWindow() {

    }

    @Override
    public void onViewDetachedFromWindow() {

    }

    @Override
    public void onViewRecycled() {

    }


    public void notifyCurrentItemChanged() {
        notifyItemChanged(getAdapterPosition());
    }

    @Override
    public void notifyDataSetChanged() {
        getAdapter().notifyDataSetChanged();
    }

    @Override
    public void notifyItemChanged(int position) {
        getAdapter().notifyItemChanged(position);
    }

    @Override
    public void notifyItemChanged(int position, @Nullable Object payload) {
        getAdapter().notifyItemChanged(position,payload);
    }

    @Override
    public void notifyItemRangeChanged(int positionStart, int itemCount) {
        getAdapter().notifyItemRangeChanged(positionStart,itemCount);
    }

    @Override
    public void notifyItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
        getAdapter().notifyItemRangeChanged(positionStart,itemCount,payload);
    }

    @Override
    public void notifyItemInserted(int position) {
        getAdapter().notifyItemInserted(position);
    }

    @Override
    public void notifyItemMoved(int fromPosition, int toPosition) {
        getAdapter().notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void notifyItemRangeInserted(int positionStart, int itemCount) {
        getAdapter().notifyItemRangeInserted(positionStart,itemCount);
    }

    @Override
    public void notifyItemRemoved(int position) {
        getAdapter().notifyItemRemoved(position);
    }

    @Override
    public void notifyItemRangeRemoved(int positionStart, int itemCount) {
        getAdapter().notifyItemRangeRemoved(positionStart,itemCount);
    }
}
