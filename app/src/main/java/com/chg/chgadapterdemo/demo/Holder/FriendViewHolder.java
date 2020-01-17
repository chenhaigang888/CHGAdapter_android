package com.chg.chgadapterdemo.demo.Holder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.Model;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.R;
import com.chg.chgadapterdemo.demo.Model.Friend;

public class FriendViewHolder extends ViewHolder {

    ImageView icon;
    TextView username;
    TextView gender;

    public FriendViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        icon = itemView.findViewById(R.id.icon);
        username = itemView.findViewById(R.id.username);
        gender = itemView.findViewById(R.id.gender);
    }

    @Override
    public void onBindViewHolder(final Model model) {
        super.onBindViewHolder(model);
        Friend friend = (Friend) model;
        username.setText(friend.getUsername());
        gender.setText(friend.getGender());

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventTransmissionListener().onEventTransmission(this,model,0,null);
            }
        });
    }
}
