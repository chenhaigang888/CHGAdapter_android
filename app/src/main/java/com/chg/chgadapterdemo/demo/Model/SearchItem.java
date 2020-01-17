package com.chg.chgadapterdemo.demo.Model;

import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.R;
import com.chg.chgadapterdemo.demo.Holder.SearchItemViewHolder;

import java.util.List;

public class SearchItem implements Model {

    private int type;
    private List lits;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List getLits() {
        return lits;
    }

    public void setLits(List lits) {
        this.lits = lits;
    }

    public SearchItem(int type, List lits) {
        this.type = type;
        this.lits = lits;
    }

    @Override
    public int getResource(int position) {
        return type == 0 ? R.layout.search_item_layout  : R.layout.search_item_1_layout;
    }

    @Override
    public Class getHolderClass(int position) {
        return SearchItemViewHolder.class;
    }
}
