package com.chg.CHGAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @param <MP> MP extends ModelProtocol
 */
public class Adapter<MP extends ModelProtocol> extends RecyclerView.Adapter {

    private List<MP> models;
    private Context context;
    private EventTransmissionListener eventTransmissionListener;
    private Object customData;

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

    public Adapter(List<MP> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ModelProtocol model = models.get(viewType);
        View view = LayoutInflater.from(context).inflate(model.getResource(parent, viewType), parent, false);
        Class<RecyclerView.ViewHolder> viewHolder = model.getHolderClass(parent,viewType);
        try {
            Constructor c2 = viewHolder.getDeclaredConstructor(View.class, EventTransmissionListener.class);
            ViewHolder obj = (ViewHolder) c2.newInstance(view, eventTransmissionListener);
            obj.setParent(parent);
            return obj;
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
        ((ViewHolder) holder).onBindViewHolder(models.get(position));
    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        return models.size();
    }
}
