package com.chg.chgadapterdemo.Model;

import android.view.ViewGroup;

import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapterdemo.Holder.BannersViewHolder;
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
    public Class getHolderClass() {
        return BannersViewHolder.class;
    }
}
