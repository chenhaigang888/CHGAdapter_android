package com.chg.chgadapterdemo.Found.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.Model;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Model.FuncItem;
import com.chg.chgadapterdemo.R;

public class FuncItemViewHolder extends ViewHolder {
    private ImageView icon;
    private TextView name;

    public FuncItemViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        icon = findViewById(R.id.funcIcon);
        name = findViewById(R.id.funcName);
    }

    @Override
    public void onBindViewHolder(Model model) {
        super.onBindViewHolder(model);
        FuncItem funcItem = (FuncItem) model;

        icon.setImageResource(funcItem.getIcon());
        name.setText(funcItem.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventTransmissionListener().onEventTransmission(this,getModel(),0,null);
            }
        });
    }
}
