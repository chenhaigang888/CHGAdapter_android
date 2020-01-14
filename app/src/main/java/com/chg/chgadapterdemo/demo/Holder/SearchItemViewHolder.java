package com.chg.chgadapterdemo.demo.Holder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.demo.Model.SearchItem;
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
    public void onBindViewHolder(final ModelProtocol modelProtocol, RecyclerView.ViewHolder holder, final int position) {
        SearchItem searchItem = (SearchItem) modelProtocol;
        recyclerView.setData(searchItem.getLits());
    }
}
