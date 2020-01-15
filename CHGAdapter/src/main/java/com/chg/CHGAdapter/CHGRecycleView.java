package com.chg.CHGAdapter;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 *
 */
public class CHGRecycleView extends RecyclerView {

    public void setSlideMomentumListener(com.chg.CHGAdapter.Adapter.SlideMomentumListener slideMomentumListener) {
        ((com.chg.CHGAdapter.Adapter)getAdapter()).setSlideMomentumListener(slideMomentumListener);
    }

    public CHGRecycleView(Context context) {
        super(context);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public CHGRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public CHGRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAdapter(new com.chg.CHGAdapter.Adapter(null, getContext()));
    }

    public List<ModelProtocol> getData() {
        return ((com.chg.CHGAdapter.Adapter) getAdapter()).getModels();
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return ((com.chg.CHGAdapter.Adapter) getAdapter()).getEventTransmissionListener();
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        ((com.chg.CHGAdapter.Adapter) getAdapter()).setEventTransmissionListener(eventTransmissionListener);
    }

    public void setData(List<ModelProtocol> data) {
        com.chg.CHGAdapter.Adapter adapter = (com.chg.CHGAdapter.Adapter) getAdapter();
        adapter.setModels(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof com.chg.CHGAdapter.Adapter) {
            super.setAdapter(adapter);
        } else
            new Exception("CHGRecycleView's adapter must use com.example.test.CHGAdapter.Adapter or sub Class of com.example.test.CHGAdapter.Adapter");
    }
}
