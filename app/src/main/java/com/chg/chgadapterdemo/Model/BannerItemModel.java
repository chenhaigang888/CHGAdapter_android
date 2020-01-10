package com.chg.chgadapterdemo.Model;


import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Holder.BannerItemViewHolder;
import com.chg.chgadapterdemo.R;

public class BannerItemModel implements ModelProtocol {

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.banner_item_layout;
    }

    @Override
    public Class getHolderClass() {
        return BannerItemViewHolder.class;
    }
}
