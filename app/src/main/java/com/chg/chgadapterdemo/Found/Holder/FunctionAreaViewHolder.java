package com.chg.chgadapterdemo.Found.Holder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FunctionArea;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FunctionAreaViewHolder extends ViewHolder {

    private CHGRecycleView recycleView;

    public FunctionAreaViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        recycleView = findViewById(R.id.funcRecycleView);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recycleView.setLayoutManager(manager);
    }

    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol) {
        FunctionArea functionArea = (FunctionArea) modelProtocol;

        recycleView.setData((List) functionArea.getFuncItems());
    }
}
