package com.chg.CHGAdapter;

import android.view.ViewGroup;

/**
 * 所有model需要实现这个接口
 */
public interface ModelProtocol {
    /**
     * 返回当前model对应的布局文件 例如：R.layout.xxx
     * @param parent
     * @param position 当前model在第几个位置
     * @return
     */
    public int getResource(ViewGroup parent, int position);

    /**
     * 当model所对应的Holder类
     * @return
     */
    public Class getHolderClass(ViewGroup parent, int position);

}

