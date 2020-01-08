package com.chg.chgadapterdemo.Model;

import android.view.ViewGroup;


import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapterdemo.Holder.UserViewHolder;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class User implements ModelProtocol {

    private String icon;
    private String username;
    private String gender;
    private List<ModelProtocol> friends;

    public List<ModelProtocol> getFriends() {
        return friends;
    }

    public void setFriends(List<ModelProtocol> friends) {
        this.friends = friends;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.user_layout;
    }

    @Override
    public Class getHolderClass() {
        return UserViewHolder.class;
    }
}
