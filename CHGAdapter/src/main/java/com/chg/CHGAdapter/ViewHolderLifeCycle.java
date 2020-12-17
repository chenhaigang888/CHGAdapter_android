package com.chg.CHGAdapter;



/**
 * ViewHolder生命周期
 * @param <M>
 */
public interface ViewHolderLifeCycle<M extends Model> {

    /**
     * 绑定数据
     *
     * @param model 具体的数据
     */
    public void onBindViewHolder(M model);

    /**
     * 将要显示
     */
    public void onViewAttachedToWindow();

    /**
     * 不在显示
     */
    public void onViewDetachedFromWindow();


    /**
     * 即将销毁
     */
    public void onViewRecycled();
}
