package com.chg.chgadapterdemo.Holder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chg.chgadapter.EventTransmissionListener;
import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapter.ViewHolder;
import com.chg.chgadapterdemo.Model.Friend;
import com.chg.chgadapterdemo.R;

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
    public void onBindViewHolder(final ModelProtocol modelProtocol) {
        Friend friend = (Friend) modelProtocol;
        username.setText(friend.getUsername());
        gender.setText(friend.getGender());

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventTransmissionListener().onEventTransmission(this,modelProtocol,0,null);
            }
        });
    }
}
