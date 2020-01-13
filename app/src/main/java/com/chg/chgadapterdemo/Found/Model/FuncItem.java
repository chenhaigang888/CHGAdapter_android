package com.chg.chgadapterdemo.Found.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Found.Holder.FuncItemViewHolder;
import com.chg.chgadapterdemo.R;

public class FuncItem implements ModelProtocol {

    private String name;
    private int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.func_item;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return FuncItemViewHolder.class;
    }
}
