package com.chg.chgadapterdemo.Found.Model;

import com.chg.CHGAdapter.Model;
import com.chg.CHGAdapter.ViewHolder;

class Circle implements Model {
    @Override
    public int getResource(int position) {
        return 0;
    }

    @Override
    public Class<ViewHolder<Model>> getHolderClass(int position) {
        return null;
    }
}
