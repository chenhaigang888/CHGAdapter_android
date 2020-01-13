package com.chg.chgadapterdemo.demo.Model;


import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.demo.Holder.BannerItemViewHolder;
import com.chg.chgadapterdemo.R;

public class BannerItemModel implements ModelProtocol {

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.banner_item_layout;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return BannerItemViewHolder.class;
    }
}
