package com.chg.chgadapterdemo.Found.Model;

import android.view.ViewGroup;

import com.chg.CHGAdapter.Model;
import com.chg.CHGAdapter.ViewHolder;
import com.chg.chgadapterdemo.Found.Holder.FunctionAreaViewHolder;
import com.chg.chgadapterdemo.R;

import java.util.List;

public class FunctionArea implements Model {

    private List<FuncItem> funcItems;

    public List<FuncItem> getFuncItems() {
        return funcItems;
    }

    public void setFuncItems(List<FuncItem> funcItems) {
        this.funcItems = funcItems;
    }

    @Override
    public int getResource(int position) {
        return R.layout.function_area;
    }

    @Override
    public Class getHolderClass(int position) {
        return FunctionAreaViewHolder.class;
    }
}
