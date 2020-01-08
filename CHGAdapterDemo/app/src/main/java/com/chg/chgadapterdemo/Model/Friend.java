package com.chg.chgadapterdemo.Model;


import android.view.ViewGroup;

import com.chg.chgadapterdemo.Holder.FriendViewHolder;
import com.chg.chgadapterdemo.R;

public class Friend extends User {
    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.friend_layout;
    }

    @Override
    public Class getHolderClass() {
        return FriendViewHolder.class;
    }
}
