package com.chg.CHGAdapter;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CHGRecyclerView<M extends Model> extends RecyclerView implements Notify{

    /**
     * 设置 itemClickListener
     * @param onItemClickListener
     */
    public void setOnItemClickListener(com.chg.CHGAdapter.Adapter.OnItemClickListener onItemClickListener) {
        ((com.chg.CHGAdapter.Adapter)getAdapter()).setOnItemClickListener(onItemClickListener);
    }

    /**
     * 设置 onItemLongClickListener
     * @param onItemLongClickListener
     */
    public void setOnItemLongClickListener(com.chg.CHGAdapter.Adapter.OnItemLongClickListener onItemLongClickListener) {
        ((com.chg.CHGAdapter.Adapter)getAdapter()).setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setSlideMomentumListener(com.chg.CHGAdapter.Adapter.SlideMomentumListener slideMomentumListener) {
        ((com.chg.CHGAdapter.Adapter)getAdapter()).setSlideMomentumListener(slideMomentumListener);
    }

    public CHGRecyclerView(Context context) {
        super(context);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public CHGRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public CHGRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public List<M> getData() {
        return ((com.chg.CHGAdapter.Adapter) getAdapter()).getModels();
    }

    public void setCustomData(Object customData){
        ((com.chg.CHGAdapter.Adapter)getAdapter()).setCustomData(customData);
    }

    public Object getCustomData(){
        return ((com.chg.CHGAdapter.Adapter)getAdapter()).getCustomData();
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return ((com.chg.CHGAdapter.Adapter) getAdapter()).getEventTransmissionListener();
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        ((com.chg.CHGAdapter.Adapter) getAdapter()).setEventTransmissionListener(eventTransmissionListener);
    }

    public void setModels(List<M> models) {
        com.chg.CHGAdapter.Adapter adapter = (com.chg.CHGAdapter.Adapter) getAdapter();
        adapter.setModels(models);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof com.chg.CHGAdapter.Adapter) {
            super.setAdapter(adapter);
        } else
            new Exception("CHGRecycleView's adapter must use com.example.test.CHGAdapter.Adapter or sub Class of com.example.test.CHGAdapter.Adapter");
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
        getAdapter().notifyItemRangeChanged(positionStart, itemCount, payload);
    }

    @Override
    public void notifyItemInserted(int position) {
        getAdapter().notifyItemInserted(position);
    }

    @Override
    public void notifyItemMoved(int fromPosition, int toPosition) {
        getAdapter().notifyItemMoved(fromPosition, toPosition);
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
        getAdapter().notifyItemRangeRemoved(positionStart, itemCount);
    }
}
