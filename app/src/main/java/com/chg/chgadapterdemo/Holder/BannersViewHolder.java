package com.chg.chgadapterdemo.Holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.chgadapter.CHGRecycleView;
import com.chg.chgadapter.EventTransmissionListener;
import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapter.ViewHolder;
import com.chg.chgadapterdemo.Model.BannersModel;
import com.chg.chgadapterdemo.R;


public class BannersViewHolder extends ViewHolder {

    CHGRecycleView recyclerView;

    public BannersViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        recyclerView = itemView.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol) {
        BannersModel model = (BannersModel) modelProtocol;
        recyclerView.setData(model.getBannerItemModels());
    }
}
