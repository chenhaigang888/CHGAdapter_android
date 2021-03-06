package com.chg.CHGAdapter;


import androidx.annotation.Nullable;

/**
 * 事件传输
 */
public interface EventTransmissionListener {

    /**
     * 统一的事件传输方法
     *
     * @param target   事件发生的场所（一般是某一个布局或者Holder）
     * @param params   事件需要向外部传递的参数
     * @param eventId      当一个view中出现多个事件使用这个参数来区分
     * @param callBack 异步回调返回数据
     * @return 同步返回数据
     */
    @Nullable
    Object onEventTransmission(@Nullable Object target,@Nullable Object params, int eventId, @Nullable CallBack callBack);

    /**
     * 回调
     */
     interface CallBack {
        /**
         * 回调
         *
         * @param object 回调传递的内容
         * @return 同步返回数据
         */
        public @Nullable Object callBack(@Nullable Object object);
    }
}

