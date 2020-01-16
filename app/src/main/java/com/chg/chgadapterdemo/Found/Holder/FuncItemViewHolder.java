package com.chg.chgadapterdemo.Found.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
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
    public void onBindViewHolder(ModelProtocol modelProtocol) {
        FuncItem funcItem = (FuncItem) modelProtocol;

        icon.setImageResource(funcItem.getIcon());
        name.setText(funcItem.getName());
    }
}
