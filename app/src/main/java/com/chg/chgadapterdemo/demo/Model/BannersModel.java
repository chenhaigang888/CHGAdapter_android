package com.chg.chgadapterdemo.demo.Model;

import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.R;
import com.chg.chgadapterdemo.demo.Holder.BannersViewHolder;

import java.util.List;

public class BannersModel implements Model {

    private List<Model> bannerItemModels;

    public List<Model> getBannerItemModels() {
        return bannerItemModels;
    }

    public void setBannerItemModels(List<Model> bannerItemModels) {
        this.bannerItemModels = bannerItemModels;
    }

    @Override
    public int getResource(int position) {
        return R.layout.banners;
    }

    @Override
    public Class getHolderClass(int position) {
        return BannersViewHolder.class;
    }
}
