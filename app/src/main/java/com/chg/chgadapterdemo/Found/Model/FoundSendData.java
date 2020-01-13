package com.chg.chgadapterdemo.Found.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Found.Holder.FoundSendDataViewHolder;
import com.chg.chgadapterdemo.demo.Model.User;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FoundSendData implements ModelProtocol {
    private FoundContent content;
    private Boolean hasLike;
    private Boolean hasDislike;
    private Boolean hasCollect;
    private String source;
    private FoundUser user;
    private List<User> likes;
    private Integer coins;
    private Integer integral;
    private FoundGroup group;
    private Circle circle;


    public FoundContent getContent() {
        return content;
    }

    public void setContent(FoundContent content) {
        this.content = content;
    }

    public Boolean getHasLike() {
        return hasLike;
    }

    public void setHasLike(Boolean hasLike) {
        this.hasLike = hasLike;
    }

    public Boolean getHasDislike() {
        return hasDislike;
    }

    public void setHasDislike(Boolean hasDislike) {
        this.hasDislike = hasDislike;
    }

    public Boolean getHasCollect() {
        return hasCollect;
    }

    public void setHasCollect(Boolean hasCollect) {
        this.hasCollect = hasCollect;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public FoundUser getUser() {
        return user;
    }

    public void setUser(FoundUser user) {
        this.user = user;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public FoundGroup getGroup() {
        return group;
    }

    public void setGroup(FoundGroup group) {
        this.group = group;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.found_send_data_item;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return FoundSendDataViewHolder.class;
    }

}

