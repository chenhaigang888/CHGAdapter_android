package com.chg.chgadapterdemo.demo.Model;

import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.R;
import com.chg.chgadapterdemo.demo.Holder.UserViewHolder;

import java.util.List;

public class User implements Model {

    private String icon;
    private String username;
    private String gender;
    private List<Model> friends;

    public List<Model> getFriends() {
        return friends;
    }

    public void setFriends(List<Model> friends) {
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
    public int getResource(int position) {
        return R.layout.user_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return UserViewHolder.class;
    }
}
