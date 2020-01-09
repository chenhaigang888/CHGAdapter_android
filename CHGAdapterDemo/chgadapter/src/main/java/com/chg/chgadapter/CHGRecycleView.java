package com.chg.chgadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CHGRecycleView<MP extends  ModelProtocol> extends RecyclerView  {


    private List<MP> data;

    public CHGRecycleView(@NonNull Context context) {
        super(context);
    }

    public CHGRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CHGRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public List<MP> getData() {
        return data;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return ((com.chg.chgadapter.Adapter)getAdapter()).getEventTransmissionListener();
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        ((com.chg.chgadapter.Adapter)getAdapter()).setEventTransmissionListener(eventTransmissionListener);
    }

    public void setData(List<MP> data) {
        this.data = data;
        setAdapter(new com.chg.chgadapter.Adapter(data,getContext()));
    }


    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        if (adapter instanceof com.chg.chgadapter.Adapter) {
            super.setAdapter(adapter);
        } else new Exception("CHGRecycleView's adapter must use com.example.test.CHGAdapter.Adapter or sub Class of com.example.test.CHGAdapter.Adapter");
    }
}
