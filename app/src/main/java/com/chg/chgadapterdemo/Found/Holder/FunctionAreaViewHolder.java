package com.chg.chgadapterdemo.Found.Holder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.CHGAdapter.CHGRecyclerView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FunctionArea;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FunctionAreaViewHolder extends ViewHolder<FunctionArea> {

    private CHGRecyclerView recycleView;

    public FunctionAreaViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener, ViewGroup parent) {
        super(itemView, eventTransmissionListener, parent);
        recycleView = findViewById(R.id.funcRecycleView);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recycleView.setLayoutManager(manager);
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void onBindViewHolder(FunctionArea model) {
        super.onBindViewHolder(model);
//        FunctionArea functionArea = (FunctionArea) model;

        recycleView.setModels((List) model.getFuncItems());
        recycleView.setEventTransmissionListener(getEventTransmissionListener());
    }
}
