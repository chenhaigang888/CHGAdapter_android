package com.chg.CHGAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @param <M> M extends Model
 */
public class Adapter<M extends Model> extends RecyclerView.Adapter {

    /**
     * 监听滑动的数量
     */
    public interface SlideMomentumListener {
        /**
         * 设置剩余数量没展示的时候发出回调。当剩余的item数量小于设置的数量 onRemainingAmount方法回被回调
         *
         * @return
         */
         int onRemainingAmount();

        /**
         * 达到设置的剩余量时候触发
         */
         void onArriveRemainingAmount();
    }

    private List<M> models;
    private Context context;
    private EventTransmissionListener eventTransmissionListener;
    private SlideMomentumListener slideMomentumListener;
    private Object customData;
    //和viewType一一对应
    private Class<ViewHolder<Model>> viewHolderClass;

    public SlideMomentumListener getSlideMomentumListener() {
        return slideMomentumListener;
    }

    public void setSlideMomentumListener(SlideMomentumListener slideMomentumListener) {
        this.slideMomentumListener = slideMomentumListener;
    }

    public List<M> getModels() {
        return models;
    }

    public void setModels(List<M> models) {
        this.models = models;
    }

    public Object getCustomData() {
        return customData;
    }

    public void setCustomData(Object customData) {
        this.customData = customData;
    }

    public EventTransmissionListener getEventTransmissionListener() {
        return eventTransmissionListener;
    }

    public void setEventTransmissionListener(EventTransmissionListener eventTransmissionListener) {
        this.eventTransmissionListener = eventTransmissionListener;
    }

    public Adapter(List<M> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        viewHolderClass = models.get(position).getHolderClass(position);
        return models.get(position).getResource(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        try {
            Constructor constructor = viewHolderClass.getDeclaredConstructor(View.class, EventTransmissionListener.class,ViewGroup.class);
            ViewHolder viewHolder = (ViewHolder) constructor.newInstance(view, eventTransmissionListener,parent);
            return viewHolder;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getSlideMomentumListener() != null && getItemCount() - position < getSlideMomentumListener().onRemainingAmount()) {
            getSlideMomentumListener().onArriveRemainingAmount();
        }
        ((ViewHolder) holder).onBindViewHolder(models.get(position));
    }

    /**
     * （当Item进入这个页面的时候调用）
     *
     * @param holder
     */
    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ((ViewHolder) holder).onViewAttachedToWindow();
    }

    /**
     * （当Item离开这个页面的时候调用）
     *
     * @param holder
     */
    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        ((ViewHolder) holder).onViewDetachedFromWindow();
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        ((ViewHolder) holder).onViewRecycled();
    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        return models.size();
    }
}
