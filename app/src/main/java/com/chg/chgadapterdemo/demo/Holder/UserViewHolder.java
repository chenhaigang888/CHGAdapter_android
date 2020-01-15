package com.chg.chgadapterdemo.demo.Holder;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.demo.Model.User;
import com.chg.chgadapterdemo.R;

public class UserViewHolder extends ViewHolder {

    ImageView icon;
    TextView username;
    TextView gender;
    CHGRecycleView recyclerView;

    public UserViewHolder(@NonNull View itemView, EventTransmissionListener eventTransmissionListener) {
        super(itemView, eventTransmissionListener);
        icon = itemView.findViewById(R.id.icon);
        username = itemView.findViewById(R.id.username);
        gender = itemView.findViewById(R.id.gender);
        recyclerView = itemView.findViewById(R.id.recyclerView);
    }


    @Override
    public void onBindViewHolder(final ModelProtocol modelProtocol) {
        User user = (User) modelProtocol;
        username.setText(user.getUsername());
        gender.setText(user.getGender());

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventTransmissionListener().onEventTransmission(v,modelProtocol,0,null);
            }
        });

        //好友
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(manager);
        recyclerView.setData(user.getFriends());

        recyclerView.setEventTransmissionListener(new EventTransmissionListener() {
            @Override
            public Object onEventTransmission(Object target, Object params, int tag, CallBack callBack) {
                getEventTransmissionListener().onEventTransmission(this,params,tag,callBack);
                return null;
            }
        });
    }
}

