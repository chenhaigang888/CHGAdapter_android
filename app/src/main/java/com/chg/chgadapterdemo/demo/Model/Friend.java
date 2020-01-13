package com.chg.chgadapterdemo.demo.Model;


import android.view.ViewGroup;

import com.chg.chgadapterdemo.demo.Holder.FriendViewHolder;
import com.chg.chgadapterdemo.R;

public class Friend extends User {
    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.friend_layout;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return FriendViewHolder.class;
    }
}
