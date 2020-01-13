package com.chg.chgadapterdemo.demo.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.demo.Holder.BannersViewHolder;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class BannersModel implements ModelProtocol {

    private List<ModelProtocol> bannerItemModels;

    public List<ModelProtocol> getBannerItemModels() {
        return bannerItemModels;
    }

    public void setBannerItemModels(List<ModelProtocol> bannerItemModels) {
        this.bannerItemModels = bannerItemModels;
    }

    @Override
    public int getResource(ViewGroup parent, int position) {
        return R.layout.banners;
    }

    @Override
    public Class getHolderClass(ViewGroup parent, int position) {
        return BannersViewHolder.class;
    }
}
