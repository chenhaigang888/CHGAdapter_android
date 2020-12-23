package com.chg.CHGAdapter;


/**
 * 所有model需要实现这个接口
 */
public interface Model {
    /**
     * 返回当前model对应的布局文件 例如：R.layout.xxx
     *
     * @param position 当前model在第几个位置
     * @return 返回布局文件
     */
     int getResource(int position);

    /**
     * 当model所对应的Holder类
     *
     * @return  返回ViewHolder
     */
     Class getHolderClass(int position);

}

