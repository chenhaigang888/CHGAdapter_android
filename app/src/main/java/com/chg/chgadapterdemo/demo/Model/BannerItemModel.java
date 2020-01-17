package com.chg.chgadapterdemo.demo.Model;


import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.R;
import com.chg.chgadapterdemo.demo.Holder.BannerItemViewHolder;

public class BannerItemModel implements Model {

    @Override
    public int getResource(int position) {
        return R.layout.banner_item_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return BannerItemViewHolder.class;
    }
}
