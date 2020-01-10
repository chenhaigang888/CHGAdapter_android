package com.chg.chgadapterdemo.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Holder.SearchItemViewHolder;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class SearchItem implements ModelProtocol {

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
    public int getResource(ViewGroup parent, int position) {
        return type == 0 ? R.layout.search_item_layout  : R.layout.search_item_1_layout;
    }

    @Override
    public Class getHolderClass() {
        return SearchItemViewHolder.class;
    }
}
