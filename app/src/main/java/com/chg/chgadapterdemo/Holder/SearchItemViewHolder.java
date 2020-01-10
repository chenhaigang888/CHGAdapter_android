package com.chg.chgadapterdemo.Holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.chgadapter.CHGRecycleView;
import com.chg.chgadapter.EventTransmissionListener;
import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapter.ViewHolder;
import com.chg.chgadapterdemo.MainActivity;
import com.chg.chgadapterdemo.Model.SearchItem;
import com.chg.chgadapterdemo.R;

public class SearchItemViewHolder extends ViewHolder {
    private CHGRecycleView recyclerView;

    public SearchItemViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);

        recyclerView = itemView.findViewById(R.id.recycleView);

        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(manager);



    }

    @Override
    public void onBindViewHolder(ModelProtocol modelProtocol) {
        SearchItem searchItem = (SearchItem) modelProtocol;
        recyclerView.setData(searchItem.getLits());
    }
}
