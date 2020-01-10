package com.chg.CHGAdapter;

import android.content.Context;
import android.util.AttributeSet;


import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

/**
 *
 */
public class CHGRecycleView extends RecyclerView {


    private List<ModelProtocol> data;

    public CHGRecycleView(Context context) {
        super(context);
    }

    public CHGRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CHGRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public List<ModelProtocol> getData() {
        return data;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return ((com.chg.CHGAdapter.Adapter) getAdapter()).getEventTransmissionListener();
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        ((com.chg.CHGAdapter.Adapter) getAdapter()).setEventTransmissionListener(eventTransmissionListener);
    }

    public void setData(List<ModelProtocol> data) {
        this.data = data;
        setAdapter(new com.chg.CHGAdapter.Adapter(data, getContext()));
    }


    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof com.chg.CHGAdapter.Adapter) {
            super.setAdapter(adapter);
        } else
            new Exception("CHGRecycleView's adapter must use com.example.test.CHGAdapter.Adapter or sub Class of com.example.test.CHGAdapter.Adapter");
    }
}
